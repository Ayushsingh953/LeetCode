// https://leetcode.com/problems/number-of-islands/

class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    Dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void Dfs(char[][] grid,int i,int j){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!='1')return;
        grid[i][j] = '0';
        Dfs(grid,i+1,j);
        Dfs(grid,i-1,j);
        Dfs(grid,i,j+1);
        Dfs(grid,i,j-1);
    }
}