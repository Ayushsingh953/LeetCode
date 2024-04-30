// https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int idx=0,sign=1,total=0;

        if(s.length() == 0) return 0;

        if(s.charAt(idx) == '+' || s.charAt(idx) == '-'){
            sign = s.charAt(idx) == '+' ? 1 : -1;
            idx++;
        }
        while(idx < s.length()){
            int digit = s.charAt(idx) - '0';
            if(digit < 0 || digit > 9) break;

            if(Integer.MAX_VALUE/10<total || Integer.MAX_VALUE/10==total
             && Integer.MAX_VALUE%10<digit){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total*10+digit;
            idx++;
        }
        return total*sign;
    }
}