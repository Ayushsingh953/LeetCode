// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/


//Brute force
class Solution1 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    res[i]++;
                }
            }
        }
        return res;
    }
}

// Counting sort

class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] count=new int[101];
        int[] res=new int[n];

        for(int i=0;i<n;i++){
            count[nums[i]]++;
        }

        for(int i=1;i<101;i++){
            count[i]+=count[i-1];
        }
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                res[i]=0;
                else
                res[i]=count[nums[i]-1];
                }
        return res;
    }
}