// https://leetcode.com/problems/left-and-right-sum-differences/

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] leftSum= new int[n];
        int[] rightSum= new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                leftSum[i]+=nums[j];
            }
            for(int j=n-1;j>i;j--){
                rightSum[i]+=nums[j];
            }
        }
        for(int i=0;i<n;i++){
            nums[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return nums;
    }
}

class Solution2 {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int i;int leftsum[]=new int[n]; int rightsum[]=new int[n];
        int prefix[]=new int[n];int suffix[]=new int[n];

        prefix[0]=nums[0];
        suffix[0]=nums[n-1];
        
        for(i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
            suffix[i]=suffix[i-1]+nums[n-i-1];
        }
        for(i=0;i<n;i++){
            leftsum[i]=prefix[i]-nums[i];
            rightsum[i]=suffix[n-i-1]-nums[i];
        }
        for(i=0;i<n;i++){
            nums[i]=Math.abs(leftsum[i]-rightsum[i]);
        }
        return nums;
        
    }
}

class Solution3 {
    public int[] leftRightDifference(int[] nums) {
        
        int n = nums.length,sum=0;
        int arr[] = new int[n];
        for(int i = 0 ; i< n;i++){
            sum += nums[i];
        }
        int rightSum = sum;
        int leftSum = 0;
        for(int i = 0 ; i< n;i++){
            rightSum -= nums[i];
            arr[i] = Math.abs(leftSum - rightSum); 
            leftSum += nums[i];

        }
        return arr;
    }
}