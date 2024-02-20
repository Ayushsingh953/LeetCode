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


// Without using extra space
// Store the pair of numbers
class Solution2 {
    public int[] shuffle(int[] nums, int n) {
        for(int i=n;i<2*n;i++){
            nums[i]=(nums[i]*1024)+nums[i-n];
        }
        int k=0;
        for(int i=n;i<2*n;i++){
            nums[k++]=nums[i]%1024;
            nums[k++]=nums[i]/1024;
        }
        return nums;
    }
}