// https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int maxArea(int[] height) {
        int max_area=0;
        int i=0,j=height.length-1;
       while(i<j)
       {
             max_area =Math.max(max_area,(Math.min(height[i],height[j])*(j-i)));
          if(height[i]<height[j])
              i++;
           else
               j--;
       }
        return max_area;
    }
}