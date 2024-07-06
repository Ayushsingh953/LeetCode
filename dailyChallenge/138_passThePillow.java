// https://leetcode.com/problems/pass-the-pillow/

class Solution {
    public int passThePillow(int n, int time) {
        int round = time/(n-1);
        int extraTime = time % (n-1);

        if(round%2==0){
            return extraTime+1;
        }
        return n-extraTime;
    }
}