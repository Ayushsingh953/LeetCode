// https://leetcode.com/problems/kth-distinct-string-in-an-array/

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> freq = new HashMap<>();
        for(String s:arr){
            freq.put(s,freq.getOrDefault(s,0)+1);
        }

        String res = "";
        for(String s:arr){
            int f = freq.get(s);
            if(f==1) k--;
            if(k==0){
                res = s;
                break;
            }
        }
        return res;
    }
}