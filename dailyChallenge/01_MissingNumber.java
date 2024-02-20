// https://leetcode.com/problems/missing-number/?envType=daily-question&envId=2024-02-20

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }
}

// Solution 2
class Solution1 {
    public int missingNumber(int[] nums) {
       int s=0,sum=0;
       int n=nums.length;
       for(int i=0;i<n;i++){
           s+=nums[i];
       }
       sum=(n*(n+1))/2;
       return sum-s;
    }
}