// https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
         long max=Integer.MIN_VALUE;
        for(int i=0;i<=nums.length-k;i++){
            int j=i;
            sum=0;
            while(j<i+k){
                sum+=nums[j];
                j++;
            }
            max=Math.max(max,sum);
        }
        return max/1.0/k;
    }
}

class Solution2 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
         long max=sum;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            max=Math.max(max,sum);
        }
        return max/1.0/k;
    }
}