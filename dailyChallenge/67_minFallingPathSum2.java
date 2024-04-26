// https://leetcode.com/problems/minimum-falling-path-sum-ii/?envType=daily-question&envId=2024-04-26

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp =new int[n][n];

        for(int col = 0;col<n;col++){
            dp[n-1][col] = grid[n-1][col];
        }

        for(int row = n-2;row>=0;row--){
            for(int col = 0;col<n;col++){
                int nextMin = Integer.MAX_VALUE;
                for(int nextRowCol = 0;nextRowCol<n;nextRowCol++){
                    if(nextRowCol != col){
                        nextMin = Math.min(nextMin,dp[row+1][nextRowCol]);
                    }
                }
                dp[row][col] = nextMin+grid[row][col];
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int col = 0;col<n;col++){
            ans = Math.min(ans,dp[0][col]);
        }
        return ans;
    }
}