// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

class Solution {

    public int longestSubarray(int[] nums, int limit) {

        TreeMap<Integer, Integer> window = new TreeMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; ++right) {
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

          
            while (window.lastKey() - window.firstKey() > limit) {
                window.put(nums[left], window.get(nums[left]) - 1);
                if (window.get(nums[left]) == 0) {
                    window.remove(nums[left]);
                }
               
                ++left;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}