// https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,right;
        for(right=0;right<nums.length;right++){
            if(nums[right]==0) k--;
            if(k<0 && nums[left++]==0) k++;
        }
        return right-left;
    }
}