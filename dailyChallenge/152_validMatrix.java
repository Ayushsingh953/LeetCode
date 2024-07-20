// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length,m = colSum.length;
        int[] curRowSum = new int[n];
        int[] curColSum = new int[m];

        int[][] matrix = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = Math.min(rowSum[i]-curRowSum[i],colSum[j]-curColSum[j]);
                curRowSum[i]+=matrix[i][j];
                curColSum[j]+=matrix[i][j];
            }
        }
        return matrix;
    }
}

class Solution12 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length,m = colSum.length;

        int[][] matrix = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = Math.min(rowSum[i],colSum[j]);
                rowSum[i]-=matrix[i][j];
                colSum[j]-=matrix[i][j];
            }
        }
        return matrix;
    }
}

class Solution3 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length,m = colSum.length;

        int[][] matrix = new int[n][m];
        int i=0,j=0;
        while(i<n && j<m){
            matrix[i][j] = Math.min(rowSum[i],colSum[j]);
            rowSum[i]-=matrix[i][j];
            colSum[j]-=matrix[i][j];
            if(rowSum[i]==0){
                i++;
            }else{
                j++;
            }
        }
        return matrix;
    }
}