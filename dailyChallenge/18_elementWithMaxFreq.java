// https://leetcode.com/problems/count-elements-with-maximum-frequency/

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count=new int[101];
        for(int num:nums){
            count[num]++;
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=100;i++){
            max=Math.max(max,count[i]);
        }
        int sum=0;
        for(int i=1;i<=100;i++){
            if(count[i]==max){
                sum+=count[i];
            }
        }
        return sum;
    }
}