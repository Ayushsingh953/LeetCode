// https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum=0,leftSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(leftSum==totalSum-leftSum-nums[i]) {
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}