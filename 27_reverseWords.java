// https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String reverseWords(String s) {
        String[] st = s.trim().split(" +");
        int i=0,j=st.length-1;
        while(i<j){
            String t = st[i];
            st[i] = st[j];
            st[j] = t;
            i++;
            j--;
        }
        return String.join(" ",st);
    }
}