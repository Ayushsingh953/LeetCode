// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int count=0;
        for(int i =0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                if(nums.get(i)+nums.get(j)<target){
                    count++;
                }
            }
        }
        return count;
    }
}


// Using two pointers 
class Solution2 {
    public int countPairs(List<Integer> nums, int target) {
        int count=0;
        Collections.sort(nums);
        int left=0,right=nums.size()-1;
        while(left<right){
            if(nums.get(left)+nums.get(right)<target){
                count+=right-left;
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}