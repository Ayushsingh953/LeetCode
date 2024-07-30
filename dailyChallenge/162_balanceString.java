// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/?envType=daily-question&envId=2024-07-30

// Using Stack
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        Stack<Character> ch = new Stack<>();
        int deletions = 0;

        for(int i=0;i<n;i++){
            if(!ch.isEmpty() && ch.peek()=='b' && s.charAt(i)=='a'){
                ch.pop();
                deletions++;
            }else{
                ch.push(s.charAt(i));
            }
        }
        return deletions; 
    }
}

// Using DP
class Solution2 {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        int bCount = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b'){
                dp[i+1] = dp[i];
                bCount++;
            }else{
                dp[i+1] = Math.min(dp[i]+1,bCount);
            }
        }
        return dp[n];
    }
}