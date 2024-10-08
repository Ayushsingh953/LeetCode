// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int swap = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='['){
                st.push(ch);
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    swap++;
                }
            }
        }

        return (swap+1)/2;
    }
}