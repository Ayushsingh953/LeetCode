// https://leetcode.com/problems/sum-of-all-subset-xor-totals/

class Solution {
    public int subsetXORSum(int[] nums) {
        return xor(nums,0,0);
    }

    public int xor(int[] nums,int idx,int cur){
        if(idx==nums.length){
            return cur;
        }

        int withEle = xor(nums,idx+1,cur^nums[idx]);
        int withoutEle = xor(nums,idx+1,cur);

        return withEle+withoutEle;
    }
}