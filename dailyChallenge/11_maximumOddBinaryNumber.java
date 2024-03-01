// https://leetcode.com/problems/maximum-odd-binary-number/

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones=-1;
        int len=s.length();
        String st="";
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
        }
        int temp=ones;
        while(ones>0){
            st+='1';
            ones--;
        }
        while(len-temp-1>0){
            st+='0';
            len--;
        }
        st+='1';
        return st;
    }
}