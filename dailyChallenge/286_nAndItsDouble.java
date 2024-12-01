// https://leetcode.com/problems/check-if-n-and-its-double-exist/

class Solution {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (
                seen.contains(2 * num) ||
                (num % 2 == 0 && seen.contains(num / 2))
            ) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}