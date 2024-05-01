// https://leetcode.com/problems/reverse-prefix-of-word/

class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = 0;
        String st="";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                idx=i;
                break;
            }
        }
        for(int i=idx;i>=0;i--){
            st+=word.charAt(i);
        }
        return st+word.substring(idx+1);
    }
}