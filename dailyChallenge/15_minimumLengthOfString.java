// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/

class Solution {
    public int minimumLength(String s) {
        int l=0,r=s.length()-1;

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return s.length();
            }
                l++;
                while(s.charAt(l-1)==s.charAt(l) && l<r){
                    l++;
                }
                while(s.charAt(r-1)==s.charAt(r) && r>l){
                    r--;
                }
                s=s.substring(l,r);
                l=0;
                r=s.length()-1;
            }
        return s.length();
    }
}