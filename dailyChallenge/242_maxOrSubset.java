// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int num:nums){
            maxOr = maxOr|num;
        }

        return count(nums,0,0,maxOr);
    }

    public int count(int[] nums,int index,int current,int target){
        if(index==nums.length){
            return current==target ? 1 : 0;
        }

        int include = count(nums,index+1,current|nums[index],target);
        int exclude = count(nums,index+1,current,target);

        return include+exclude;
    }
}

// Memoization
class Solution2 {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int num:nums){
            maxOr = maxOr|num;
        }
        Integer[][] memo = new Integer[nums.length][maxOr+1];
        return count(nums,0,0,maxOr,memo);
    }

    public int count(int[] nums,int index,int current,int target,Integer[][] memo){
        if(index==nums.length){
            return current==target ? 1 : 0;
        }

        if(memo[index][current]!=null){
            return memo[index][current];
        }
        int include = count(nums,index+1,current|nums[index],target,memo);
        int exclude = count(nums,index+1,current,target,memo);

        return memo[index][current]=include+exclude;
    }
}