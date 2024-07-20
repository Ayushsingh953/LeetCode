// https://leetcode.com/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String,Integer> rows = new HashMap<>();
        int ans = 0;
        for(int[] row:grid){
            String s = Arrays.toString(row);
            rows.put(s,rows.getOrDefault(s,0)+1);
        }
        for(int i=0;i<n;i++){
            int[] col = new int[n];
            for(int j=0;j<n;j++){
                col[j] = grid[j][i];
            }
            String s = Arrays.toString(col);
            ans+=rows.getOrDefault(s,0);
        }
        return ans;
    }
}