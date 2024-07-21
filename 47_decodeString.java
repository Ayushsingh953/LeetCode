// https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String decodeString(String s) {
        int count = 0;
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder str = new StringBuilder();

        for(char ch:s.toCharArray()){
            if(isDigit(ch)){
                count=count*10 + ch - '0';
            }
            else if(ch=='['){
                countStack.push(count);
                st.push(str);
                str=new StringBuilder();
                count=0;
            }
            else if(ch==']'){
                StringBuilder temp = str;
                str=st.pop();
                for(count=countStack.pop();count>0;count--) str.append(temp);
            }
            else{
                str.append(ch);
            }
        }
         return str.toString();
    }
    public boolean isDigit(char ch){
        if(ch-'0'>=0 && ch-'0'<=9){
            return true;
        }
        return false;
    }
}