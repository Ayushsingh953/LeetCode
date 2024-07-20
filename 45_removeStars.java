// https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String removeStars(String s) {
        Stack<Character> st =  new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(s.charAt(i));
            }
        }
        String res="";
        while(!st.isEmpty()){
            res = st.pop()+res;
        }
        return res;
    }
}

class Solution2 {
    public String removeStars(String s) {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                res.deleteCharAt(res.length()-1);
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}