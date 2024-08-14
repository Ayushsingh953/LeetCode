// https://leetcode.com/problems/find-k-th-smallest-pair-distance/


// Brute force
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];

        int[] pair = new int[max+1];

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                pair[Math.abs(nums[i]-nums[j])]++;
            }
        }

        for(int i=0;i<=max;i++){
            k-=pair[i];

            if(k<=0) return i;
        }

        return -1;
    }
}