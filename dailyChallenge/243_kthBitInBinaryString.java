// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder st = new StringBuilder("0");

        while(k>st.length()){
            StringBuilder s = reverse(invert(new StringBuilder(st)));
            st.append("1");
            st.append(s);
        }

        return st.charAt(k-1);
    }

    public StringBuilder reverse(StringBuilder st){
        return st.reverse();
    }

    public StringBuilder invert(StringBuilder st){
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)=='1'){
                st.setCharAt(i,'0');
            }else{
                st.setCharAt(i,'1');
            }
        }

        return st;
    }
}