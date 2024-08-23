// https://leetcode.com/problems/fraction-addition-and-subtraction/

class Solution {
    public String fractionAddition(String expression) {
        int num = 0,denom = 1;
        int n = expression.length();
        int i = 0;
        while(i<n){
            int curNum = 0,curDenom = 0;
            boolean isNegative = false;
            char ch = expression.charAt(i);
            if(ch=='-' || ch=='+'){
                if(ch=='-') isNegative = true;
                i++;
            }
            while(Character.isDigit(expression.charAt(i))){
                curNum = curNum*10+(expression.charAt(i)-'0');
                i++;
            }
            i++;
            if(isNegative) curNum*=-1;

            while(i<n && Character.isDigit(expression.charAt(i))){
                curDenom = curDenom*10+(expression.charAt(i)-'0');
                i++;
            }

            num = num*curDenom + curNum*denom;
            denom = denom*curDenom;
        }

        int gcd = Math.abs(Gcd(num,denom));

        num/=gcd;
        denom/=gcd;

        return num+"/"+denom;
    }
    public int Gcd(int a,int b){
        if(a==0) return b;
        return Gcd(b%a,a);
    }
}