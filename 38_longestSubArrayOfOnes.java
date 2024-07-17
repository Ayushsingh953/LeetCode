// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int longestSubarray(int[] nums) {
        int start=0,end,k=1;
        for(end=0;end<nums.length;end++){
            if(nums[end]==0) k--;
            if(k<0 && nums[start++]==0) k++;
        }
        return end-start-1;
    }
}