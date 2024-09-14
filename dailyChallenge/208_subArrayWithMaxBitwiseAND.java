// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int len = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                max = nums[i];
            }
        }
        int i = 0;
        while(i<n){
            if(nums[i]==max){
                int j = i+1;
                while(j<n && nums[j]==max){
                    j++;
                }
                len = Math.max(len,j-i);
                i = j;
            }else{
                i++;
            }
        }
        
        return len;
    }
}
