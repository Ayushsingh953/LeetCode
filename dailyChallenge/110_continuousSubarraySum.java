// https://leetcode.com/problems/continuous-subarray-sum/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefix = 0;
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,-1);

        for(int i=0;i<nums.length;i++){
            prefix=(prefix+nums[i])%k;
            if(m.containsKey(prefix)){
                if(i-m.get(prefix)>1){
                    return true;
                }
            }else{
                m.put(prefix,i);
            }
        }
        return false;
    }
}