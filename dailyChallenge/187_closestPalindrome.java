// https://leetcode.com/problems/find-the-closest-palindrome/

class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        int left = len%2==0 ? len/2-1 : len/2;
        long leftHalf = Long.parseLong(n.substring(0,left+1));

        List<Long> palindromes = new ArrayList<>();

        palindromes.add(convert(leftHalf,len%2==0));
        palindromes.add(convert(leftHalf-1,len%2==0));
        palindromes.add(convert(leftHalf+1,len%2==0));
        palindromes.add((long)Math.pow(10,len-1)-1);
        palindromes.add((long)Math.pow(10,len)+1);

        long dif = Long.MAX_VALUE, num = Long.parseLong(n);
        long res = 0;
        for(long palindrome : palindromes){
            if(palindrome==num) continue;
            if(Math.abs(num-palindrome)<dif){
                dif = Math.abs(num-palindrome);
                res = palindrome;
            }
            else if(Math.abs(num-palindrome)==dif){
                res = Math.min(res,palindrome);
            }
        }
        return String.valueOf(res);
    }

    public long convert(long left,boolean even){
        long res = left;
        if(!even) left/=10;
        while(left>0){
            res = res*10 + (left%10);
            left/=10;
        }
        return res;
    }
}