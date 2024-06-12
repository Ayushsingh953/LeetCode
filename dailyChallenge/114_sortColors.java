// https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int countRed=0,countWhite=0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                countRed++;
            }
            else if(nums[i]==1){
                countWhite++;
            }
        }
        for(int i=0;i<len;i++){
            if(countRed-->0){
                nums[i]=0;
            }
            else if(countWhite-->0){
                nums[i]=1;
            }else{
                nums[i]=2;
            }
        }
    }
}