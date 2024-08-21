// https://leetcode.com/problems/strange-printer/

class Solution {
    public int strangePrinter(String s) {
        s = removeDuplicates(s);
        int n = s.length();

        return minTurns(0,n-1,s,new int[n][n]);
    }

    public int minTurns(int start,int end, String s,int[][] memo){
        if(start>end) return 0;
        if(memo[start][end]>0) return memo[start][end];

        int min = 1+minTurns(start+1,end,s,memo);

        for(int k=start+1;k<=end;k++){
            if(s.charAt(k)==s.charAt(start)){
                int turns = minTurns(start,k-1,s,memo) + minTurns(k+1,end,s,memo);
                min = Math.min(min,turns);
            }
        }

        return memo[start][end] = min;
    }

    public String removeDuplicates(String s){
        StringBuilder st = new StringBuilder();
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            st.append(ch);
            while(i<s.length() && ch==s.charAt(i)){
                i++;
            }
        }
        return st.toString();
    }
}