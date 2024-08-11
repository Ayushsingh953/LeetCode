// https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/

class Solution {
    public int minDays(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int regions = 0;

        int[][] temp1 = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                temp1[i][j] = grid[i][j];
            }
        }

        regions = countIslands(temp1,row,col);
        if(regions!=1) return 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0) continue;

                grid[i][j] = 0;

                int[][] temp2 = new int[row][col];

                for(int a=0;a<row;a++){
                    for(int b=0;b<col;b++){
                        temp2[a][b] = grid[a][b];
                    }
                }

                regions = countIslands(temp2,row,col);
                if(regions!=1) return 1;
                grid[i][j] = 1;
            }
        }

        return 2;
    }

    public int countIslands(int[][] grid,int row,int col){
        int regions = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,row,col);
                    regions++;
                }
            }
        }

        return regions;
    }

    public void dfs(int[][] grid,int i,int j,int row,int col){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]==0) return;

        grid[i][j] = 0;
        dfs(grid,i+1,j,row,col);
        dfs(grid,i-1,j,row,col);
        dfs(grid,i,j+1,row,col);
        dfs(grid,i,j-1,row,col);
    }
}