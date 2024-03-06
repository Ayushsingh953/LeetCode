// https://leetcode.com/problems/shuffle-string/

class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder st=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
                st.setCharAt(indices[i],s.charAt(i));
        }
        return st.toString();
    }
}