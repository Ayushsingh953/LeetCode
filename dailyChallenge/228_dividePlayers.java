// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/

class Solution {

    public long dividePlayers(int[] skill) {

        int len = skill.length;
        long total = 0;
        Arrays.sort(skill);
        int target = skill[0] + skill[len - 1];

        for (int i = 0; i < len / 2; i++) {
            int s = skill[i] + skill[len - i - 1];
            if (s != target) {
                return -1;
            }
            total += (long) skill[i] * (long) skill[len - i - 1];
        }

        return total;
    }
}