// https://leetcode.com/problems/regions-cut-by-slashes/

class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] expandedGrid = new int[n*3][n*3];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int r = i*3;
                int c = j*3;
                if(grid[i].charAt(j)=='/'){
                    expandedGrid[r][c+2] = 1;
                    expandedGrid[r+1][c+1] = 1;
                    expandedGrid[r+2][c] = 1;
                }
                else if(grid[i].charAt(j)=='\\'){
                    expandedGrid[r][c] = 1;
                    expandedGrid[r+1][c+1] = 1;
                    expandedGrid[r+2][c+2] = 1;
                }
            }
        }
        int region = 0;
        for(int i=0;i<n*3;i++){
            for(int j=0;j<n*3;j++){
                if(expandedGrid[i][j]==0){
                    dfs(expandedGrid,i,j);
                    region++;
                }
            }
        }

        return region;
    }

    public void dfs(int[][] grid,int row,int col){
        int size = grid.length;
        if(row<0 || col<0 || row>=size ||  col>=size || grid[row][col]==1) return;

        grid[row][col] = 1;
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}