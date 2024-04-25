// https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int i=0,j=n-1;
        StringBuilder sb = new StringBuilder(s);
        while(i<j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!isVowel(ci)){
                sb.setCharAt(i,ci);
                i++;
            }
            if(!isVowel(cj)){
                sb.setCharAt(j,cj);
                j--;
            }
            if(isVowel(ci) && isVowel(cj)){
                sb.setCharAt(i,cj);
                sb.setCharAt(j,ci);
                i++;
                j--;
            }
        }
        return sb.toString();
    }
    public boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'
        ||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return true;
        }
        return false;
    }
}