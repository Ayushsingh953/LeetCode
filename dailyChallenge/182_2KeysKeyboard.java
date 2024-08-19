// https://leetcode.com/problems/2-keys-keyboard/

// Recursion
class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;

        return 1+helper(1,1,n);
    }

    public int helper(int curr,int paste,int n){
        if(curr==n) return 0;
        if(curr>n) return 1000;

        int opt1 = 2+helper(curr*2,curr,n);
        int opt2 = 1+helper(curr+paste,paste,n);

        return Math.min(opt1,opt2);
    }
}

// Ussing top-down DP
class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;

        int[][] memo = new int[n][n/2+1];

        return 1+helper(1,1,n,memo);
    }

    public int helper(int curr,int paste,int n,int[][] memo){
        if(curr==n) return 0;
        if(curr>n) return 1000;

        if(memo[curr][paste]!=0) return memo[curr][paste];

        int opt1 = 2+helper(curr*2,curr,n,memo);
        int opt2 = 1+helper(curr+paste,paste,n,memo);

        return memo[curr][paste] = Math.min(opt1,opt2);
        
    }
}