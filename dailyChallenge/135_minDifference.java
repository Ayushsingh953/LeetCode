// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

class Solution {
    public int minDifference(int[] nums) {
        int len = nums.length;
        if(len<=4){
            return 0;
        }

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int left=0,right=len-4;left<4;left++,right++){
            min = Math.min(min,nums[right]-nums[left]);
        }
        return min;
    }
}