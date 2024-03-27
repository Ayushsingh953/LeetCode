// https://leetcode.com/problems/subarray-product-less-than-k/

// Sliding window
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int n=nums.length;
        int start=0,end=0,product=1,counter=0;
        while(end<n){
            product*=nums[end];
             while(start<n && product>=k){
                product/=nums[start++];
             }
            if(product<k){
                counter+=1+(end-start);
                end++;
             }
        }
        return counter;
    }
}