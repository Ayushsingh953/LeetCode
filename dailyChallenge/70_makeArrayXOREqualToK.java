// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/

class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = nums[0];
        int count = 0;
        for(int i = 1;i<nums.length;i++){
            xor^=nums[i];
        }
        while(xor>0 || k>0){
            if((xor & 1) != (k & 1)){
                count++;
            }
            xor = xor>>1;
            k = k>>1;
        }
        return count;
    }
}

class Solution2 {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        for (int n : nums) {
            finalXor = finalXor ^ n;
        }
        
        return Integer.bitCount(finalXor ^ k);
    }
}