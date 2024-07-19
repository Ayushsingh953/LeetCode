// https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/?envType=daily-question&envId=2024-07-19

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        List<Integer> rMin = new ArrayList<>();
        for(int i=0;i<m;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                min = Math.min(min,matrix[i][j]);
            }
            rMin.add(min);
        }

        List<Integer> cMax = new ArrayList<>();
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                max = Math.max(max,matrix[j][i]);
            }
            cMax.add(max);
        }
        List<Integer> lucky = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==rMin.get(i) && matrix[i][j]==cMax.get(j)){
                    lucky.add(matrix[i][j]);
                }
            }
        }
        return lucky;
    }
}