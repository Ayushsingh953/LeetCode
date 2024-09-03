// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/

class Solution {
    public int getLucky(String s, int k) {
        String num = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int n = (ch-'a') + 1;
            num+=Integer.toString(n);
        }
        while(k>0){
            int temp = 0;
            for(char ch:num.toCharArray()){
                temp+=ch-'0';
            }
            num = Integer.toString(temp);
            k--;
        }
        return Integer.parseInt(num);
    }
}