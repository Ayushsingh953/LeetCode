// https://leetcode.com/problems/largest-number/

class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] n = new String[len];

        for(int i=0;i<len;i++){
            n[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(n,(a,b)->(b+a).compareTo(a+b));

        if(n[0].charAt(0)=='0'){
            return "0";
        }

        String ans="";
        for(String str:n){
            ans+=str;
        }

        return ans;
    }
}