// https://leetcode.com/problems/length-of-last-word/

class Solution1 {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int len=s.length();
        int ans=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)==' '){
                ans=0;
            }
            else{
                ans++;
            }
        }
        return ans;
    }
}

class Solution2 {
    public int lengthOfLastWord(String s) {
        int len=s.length();
        int ans=0;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                ans++;
            }
            else if(ans!=0) break;
        }
        return ans;
    }
}