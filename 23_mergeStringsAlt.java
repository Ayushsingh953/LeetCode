// https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int i=0,j=0;
        String st="";
        while(i<len1 && j<len2){
            st+=word1.charAt(i)+""+word2.charAt(j);
            i++;
            j++;
        }
        while(i<len1){
            st+=word1.charAt(i);
            i++;
        }
        while(j<len2){
            st+=word2.charAt(j);
            j++;
        }
        return st;
    }
}