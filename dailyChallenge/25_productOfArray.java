// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix=1,n=nums.length;
        int[] suffix = new int[n];
        suffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=nums[i]*suffix[i+1];
        }
        for(int i=0;i<n;i++){
            suffix[i]=prefix*((i+1<n?suffix[i+1]:1));
            prefix*=nums[i];
        }

        return suffix;
    }
}