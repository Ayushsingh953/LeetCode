// https://leetcode.com/problems/time-needed-to-buy-tickets/

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res=0;
        for(int i=0;i<tickets.length;i++){
            res+=Math.min(tickets[i],(i>k)?tickets[k]-1:tickets[k]);
        }
        
        return res;
    }
}