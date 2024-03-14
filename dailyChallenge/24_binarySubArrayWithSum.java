// https://leetcode.com/problems/binary-subarrays-with-sum/

// Brute force solution

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
     int sum=0;
        int c=0;
        for(int i=0;i<nums.length;i++)
            {
                for(int j=i;j<nums.length;j++)
                {
                    sum+=nums[j];
                    if(sum==goal)
                    {
                        c++;
                    }
                }
            sum=0;
            }
        return c;
    }
}


//using prefixSum and Hashmap
class Solution2 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixSum=0,count=0,n=nums.length;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,1);
        for(int i=0;i<n;i++){
           prefixSum+=nums[i];
           count+=map.getOrDefault(prefixSum-goal,0);
           map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}