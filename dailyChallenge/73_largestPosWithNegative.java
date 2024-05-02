// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/

class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;

        while(i<j){
            if(nums[j]==Math.abs(nums[i]) && nums[i]<0){
                return nums[j];
            }
            else if(nums[j]>Math.abs(nums[i])){
                j--;
            }else{
                i++;
            }
        }
        return -1;
    }
}


//Using HashSet
class Solution2 {
    public int findMaxK(int[] nums) {
        int ans=-1;
        Set<Integer> s=new HashSet<>();

        for(int n:nums){
            int absNum=Math.abs(n);

            if(absNum>ans && s.contains(-n)){
                ans=absNum;
            }
            s.add(n);
        }
        return ans;
    }
}