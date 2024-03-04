// https://leetcode.com/problems/bag-of-tokens/?envType=daily-question&envId=2024-03-04

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score=0,max=0;
        int l=0,r=tokens.length-1;
        while(l<=r){
            if(power>=tokens[l]){
                power-=tokens[l];
                score++;
                l++;
                max=Math.max(max,score);
            }
            else if(score>0){
                power+=tokens[r];
                r--;
                score--;
            }else{
                break;
            }
        }
        return max;
    }
}