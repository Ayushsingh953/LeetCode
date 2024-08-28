// https://leetcode.com/problems/count-sub-islands/

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        List<List<Integer>> islandCell = new ArrayList<>();
        int m = grid1.length;
        int n = grid1[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1){
                    List<Integer> cells = new ArrayList<>();
                    dfs(grid2,i,j,cells,m,n);
                    islandCell.add(cells);
                }
            }
        }
        int subIslands = 0;
        for(List<Integer> cells:islandCell){
            boolean isSubGrid =true;
            for(Integer cell:cells){
                int i = cell/1000;
                int j = cell%1000;
                if(grid1[i][j]!=1){
                    isSubGrid = false;
                    break;
                }
            }
            if(isSubGrid) subIslands++;
        }
        return subIslands;
    }

    public void dfs(int[][] grid,int i,int j,List<Integer> cell,int row,int col){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]==0) return;
        cell.add(i*1000+j);
        grid[i][j] = 0;
        dfs(grid,i-1,j,cell,row,col);
        dfs(grid,i+1,j,cell,row,col);
        dfs(grid,i,j-1,cell,row,col);
        dfs(grid,i,j+1,cell,row,col);
    }
}