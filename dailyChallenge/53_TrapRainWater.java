// https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        int maxLeft=0,maxRight=0,total=0;
        int left=0,right=height.length-1;

        while(left<right){
            if(height[left]<height[right]){
                maxLeft=Math.max(height[left],maxLeft);
                total+=maxLeft-height[left++];
            }else{
                maxRight=Math.max(height[right],maxRight);
                total+=maxRight-height[right--];
            }
        }
        return total;
    }
}