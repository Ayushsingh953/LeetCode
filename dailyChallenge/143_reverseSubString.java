// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i =0 ;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(res.length());
            }
            else if(s.charAt(i)==')'){
                int start = st.pop();
                reverse(res,start,res.length()-1);
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
    public void reverse(StringBuilder sb,int start,int end){
        while(start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start++,sb.charAt(end));
            sb.setCharAt(end--,temp);
        }
    }
}

class Solution2 {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        int[] pair = new int[s.length()];

        for(int i =0 ;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else if(s.charAt(i)==')'){
                int j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        for(int i = 0,direction = 1;i<s.length();i+=direction){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                i=pair[i];
                direction = -direction;
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}