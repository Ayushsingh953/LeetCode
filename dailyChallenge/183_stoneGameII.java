// https://leetcode.com/problems/stone-game-ii/

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n+1];

        for(int i = n-1;i>=0;i--){
            suffixSum[i] = suffixSum[i+1]+piles[i];
        }

        return maxStone(suffixSum,1,0,new int[n][n]);
    }
    public int maxStone(int[] suffixSum,int M,int curIdx,int[][] memo){
        if(curIdx + 2*M >= suffixSum.length) return suffixSum[curIdx];

        if(memo[curIdx][M]>0) return memo[curIdx][M];

        int res = Integer.MAX_VALUE;

        for(int i=1;i<=2*M;i++){
            res = Math.min(res,
            maxStone(suffixSum,Math.max(i,M),curIdx+i,memo));
        }

        return memo[curIdx][M] = suffixSum[curIdx] - res;
    }
}