// https://leetcode.com/problems/bitwise-and-of-numbers-range/?envType=daily-question&envId=2024-02-21

// Find the common prefix by right shifting both the numbers until they become and left shift the left number as many times htey were right shifted.
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count=0;
       while(left!=right){
           left>>=1;
           right>>=1;
           count++;
       }
       return (left<<count);
    }
}