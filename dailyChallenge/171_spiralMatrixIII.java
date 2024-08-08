// https://leetcode.com/problems/spiral-matrix-iii/

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int east = 1,south = 1,west = 0,north =0;

        int[][] res = new int[rows*cols][2];
        res[0] = new int[]{rStart,cStart};
        int filledPos = 1;
        while(filledPos<rows*cols){
            // Travelling east and south
            int travelEast = east,travelSouth = south; 
            while(travelEast-->0){
                cStart++;
                if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                    int[] points = {rStart,cStart};
                    res[filledPos++] = points;
                }
            }
            while( travelSouth-->0){
                rStart++;
                if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                    int[] points = {rStart,cStart};
                    res[filledPos++] = points;
                }
            }

            // Travel west and north
            west = ++east;
            north = ++south;
            int travelWest = west,travelNorth = north;
            while(travelWest-->0){
                cStart--;
                if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                    int[] points = {rStart,cStart};
                    res[filledPos++] = points;
                }
            }
            while(travelNorth-->0){
                rStart--;
                if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                    int[] points = {rStart,cStart};
                    res[filledPos++] = points;
                }
            }
            east = ++west;
            south = ++north;
        }
        return res;
    }
}