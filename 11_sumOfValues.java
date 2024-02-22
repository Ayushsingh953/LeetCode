// https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/

class Solution {
    public static int sumIndicesWithKSetBits(List<Integer> nums,int k) {
        int len=nums.size();
        int sum=0,count=0;
        if(k==0){
            sum+=nums.get(0);
        }
        for(int i=1;i<len;i++){
            int j=i;
            count=0;
            while(j>0){
                if((j&1)==1){
                    count++;
                }
                j=j >> 1;
            }
            if(count==k){
                sum+=nums.get(i);
            }
        }
        return sum;
    }
}