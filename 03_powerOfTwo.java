// https://leetcode.com/problems/power-of-two/?envType=daily-question&envId=2024-02-19


class Solution {
    public boolean isPowerOfTwo(int n) {

        return Math.floor(Math.log(n)/Math.log(2)) == Math.ceil(Math.log(n)/Math.log(2));
        
    }
}

class Solution1 {
    public boolean isPowerOfTwo(int n) {

        return n>0 && (n & (n-1))==0;
        
    }
}