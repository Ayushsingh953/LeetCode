// https://leetcode.com/problems/integer-to-english-words/

class Solution {
    private static String[] belowTen = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private static String[] belowTwenty = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen"
    ,"Nineteen"};
    private static String[] belowHundred = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty"
    ,"Ninety"};

    public String numberToWords(int num) {
        if(num==0) return "Zero";

        return helper(num);
    }
    public String helper(int num){
        if(num<10){
            return belowTen[num];
        }
        if(num<20){
            return belowTwenty[num-10];
        }
        if(num<100){
            return belowHundred[num/10] + ( num%10 != 0 ? " " + helper(num%10) : "" );
        }
        if(num<1000){
            return helper(num/100) + " Hundred" + (num%100 != 0 ? " " + helper(num%100) : "" );
        }
        if(num<1000000){
            return helper(num/1000) + " Thousand" + (num%1000 != 0 ? " " + helper(num%1000) : "");
        }
        if(num<1000000000){
            return helper(num/1000000) + " Million" + (num%1000000 != 0 ? " " + helper(num%1000000) : "");
        }
        return helper(num/1000000000) + " Billion" + (num%1000000000 != 0 ? " " + helper(num%1000000000) : "");
    }
}