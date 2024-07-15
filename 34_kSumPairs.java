// https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        int count=0;
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum==k){
                count++;
                i++;
                j--;
            }
            else if(sum>k){
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
}

class Solution2 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum = k-nums[i];
            if(m.containsKey(sum)){
                count++;
                if(m.get(sum)==1){
                    m.remove(sum);
                }else{
                    m.put(sum,m.get(sum)-1);
                }
            }else{
                m.put(nums[i],m.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
    }
}