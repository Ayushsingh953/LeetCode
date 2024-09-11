// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        while(start>0 || goal>0){
            if(((start & 1)^(goal & 1))==1){
                count++;
            }
            start = start>>1;
            goal = goal>>1;
        }

        return count;
    }
}

// brian kernighan's algo
class Solution2 {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int xor = start^goal;

        while(xor!=0){
            xor&=xor-1;
            count++;
        }

        return count;
    }
}