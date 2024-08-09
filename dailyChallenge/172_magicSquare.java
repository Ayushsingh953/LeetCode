// https://leetcode.com/problems/magic-squares-in-grid/

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        if(rows<3 || cols<3) return count;

        int extraRow = rows-3;
        int extraCol = cols-3;

        int squares = (extraRow+1)*(extraCol+1);
        int rStart=0,cStart=0;

        for(int k=0;k<squares;k++){
            int[][] subGrid = new int[3][3];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    subGrid[i][j] = grid[rStart+i][cStart+j];
                }
            }
            if(isMagicSquare(subGrid)) count++;
            if(cStart<extraCol){
                cStart++;
                continue;
            }
            if(rStart<extraRow){
                rStart++;
                cStart = 0;
                continue;
            }
        }

        return count;
    }

    public boolean isMagicSquare(int[][] subGrid){


        int distinct = -1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(distinct==-1){
                    distinct = subGrid[i][j];
                    continue;
                }
                if(distinct==subGrid[i][j]) return false;
            }
        }
        int rSum = 0;
        for(int i=0;i<3;i++){
            int sum = 0;
            for(int j=0;j<3;j++){
                if(subGrid[i][j]==0 || subGrid[i][j]>9) return false;
                sum+=subGrid[i][j];
            }
            if(rSum==0){
                rSum = sum;
            }else{
                if(rSum != sum) return false;
            }
        }

        for(int i=0;i<3;i++){
            int sum = 0;
            for(int j=0;j<3;j++){
                if(subGrid[j][i]==0 || subGrid[j][i]>9) return false;
                sum+=subGrid[j][i];
            }
            if(sum!=rSum) return false;
        }


        int diagonal1 = 0,diagonal2 = 0;
        for(int i=0;i<3;i++){
            diagonal1+=subGrid[i][i];
            diagonal2+=subGrid[i][2-i];
        }
        if(diagonal1!=rSum || diagonal2!=rSum) return false;

        return true;
    }
}