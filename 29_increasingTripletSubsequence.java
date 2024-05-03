// https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for(int num:nums){
            if(num<=small) small = num;
            else if(num<=big) big = num;
            else return true;
        }
        return false;
    }
}