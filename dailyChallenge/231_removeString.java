// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/

class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
                continue;
            }

            if((ch=='B' && st.peek()=='A') || (ch=='D' && st.peek()=='C')){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }

        return st.size();    }
}