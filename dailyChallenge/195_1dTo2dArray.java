// https://leetcode.com/problems/convert-1d-array-into-2d-array/

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if(len!=m*n) return new int[0][0];
         
        int k = 0;
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = original[k++];
            }
        }

        return arr;
    }
}