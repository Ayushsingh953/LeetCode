// https://leetcode.com/problems/longest-palindrome/

class Solution {

    public int longestPalindrome(String s) {
        Set<Character> characterSet = new HashSet<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if (characterSet.contains(c)) {
                characterSet.remove(c);
                res += 2;
            } else {

                characterSet.add(c);
            }
        }
        if (!characterSet.isEmpty()) res++;

        return res;
    }
}