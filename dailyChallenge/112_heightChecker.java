// https://leetcode.com/problems/height-checker/

class Solution {
    public int heightChecker(int[] heights) {
        int count=0;
        int expected[]=new int[heights.length];
        for(int i=0;i<heights.length;i++){
           expected[i]=heights[i];
        }
 for(int i=0;i<expected.length-1;i++){
            int min=i;
            for(int j=i+1;j<expected.length;j++){
                if(expected[j]<expected[min]){
                    min=j;
                }
            }
            int temp=expected[min];
            expected[min]=expected[i];
            expected[i]=temp;
        }
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=expected[i]){
                count++;
            }
        }
        return count;
    }
}