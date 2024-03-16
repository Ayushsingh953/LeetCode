// https://leetcode.com/problems/contiguous-array/

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int prefixSum=0,len=0;

        for(int i=0;i<n;i++){
            prefixSum+=(nums[i]==0?-1:1);
            if(prefixSum == 0){
                len=i+1;
            }
            else if(map.containsKey(prefixSum)){
                len=Math.max(len,i-map.get(prefixSum));
            }else{
                map.put(prefixSum,i);
            }
        }
        return len;
    }
}