// https://leetcode.com/problems/find-all-duplicates-in-an-array/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int idx=Math.abs(nums[i]);
            if(nums[idx-1]<0){
                ans.add(idx);
            }
            nums[idx-1]*=-1;
        }
        return ans;
    }
}