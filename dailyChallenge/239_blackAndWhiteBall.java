// https://leetcode.com/problems/separate-black-and-white-balls/

class Solution {

    public long minimumSteps(String s) {
        long total = 0;
        int b_count = 0;

        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '0') {
                total += (long)b_count;
            } else {
                b_count++;
            }
        }

        return total;
    }
}x