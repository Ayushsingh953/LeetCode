// https://leetcode.com/problems/number-complement/

class Solution {
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num)<<1)-1;

        return num^mask;
    }
}