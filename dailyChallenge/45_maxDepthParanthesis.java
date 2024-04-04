// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

class Solution {
    public int maxDepth(String s) {
        int len=s.length();
        int left=0,right=0,max=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                left++;
            }
            else if(s.charAt(i)==')'){
                right++;
            }
            max=Math.max(max,left-right);
        }
        return max;
    }
}