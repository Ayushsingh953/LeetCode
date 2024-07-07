// https://leetcode.com/problems/water-bottles/

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while(numBottles>=numExchange){
            res+=numBottles/numExchange;
            int remBottles = (numBottles/numExchange) + (numBottles%numExchange);
            numBottles = remBottles;
        }
        return res;
    }
}