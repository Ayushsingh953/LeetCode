// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int len=points.length;
        int[] pointX=new int[len];
        for(int i=0;i<len;i++){
            pointX[i]=points[i][0];
        }
        Arrays.sort(pointX);
        int res=0;
        for(int i=1;i<len;i++){
            res=Math.max(res,(pointX[i]-pointX[i-1]));
        }
        return res;
    }
}