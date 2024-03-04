// https://leetcode.com/problems/create-target-array-in-the-given-order/

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int ind=index[i];
            if(ind<i){
                for(int j=i;j>ind;j--){
                    target[j]=target[j-1];
                }
            }
            target[ind]=nums[i];
        }
        return target;
    }
}