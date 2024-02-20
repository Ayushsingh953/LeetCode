// https://leetcode.com/problems/shuffle-the-array/


//Using extra space
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res=new int[2*n];
        int i=0,j=n,k=0;
        while(k<2*n){
            if(k%2==0){
                res[k]=nums[i];
                i++;
            }
            else{
                res[k]=nums[j];
                j++;
            }
            k++;
        }
        return res;
    }
}