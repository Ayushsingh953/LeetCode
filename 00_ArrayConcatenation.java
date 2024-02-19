// https://leetcode.com/problems/concatenation-of-array/

class Solution{
    public int[] getConcatenation(int[] nums){
        int len=nums.length;
        int[] res=new int[2*len];

        for(int i=0;i<2*len;i++){
            res[i]=nums[i%len];
        }

        return res;
    }
}