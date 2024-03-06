// https://leetcode.com/problems/decompress-run-length-encoded-list/

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int freq,val,j=0;
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<nums.length-1;i+=2){
            freq=nums[i];
            val=nums[i+1];
            while(freq-->0){
                res.add(val);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}