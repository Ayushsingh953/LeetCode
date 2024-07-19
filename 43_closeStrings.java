// https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch:word1.toCharArray()){
            freq1[ch-'a']++;
        }
        for(char ch:word2.toCharArray()){
            if(freq1[ch-'a']==0) return false;
            freq2[ch-'a']++;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for(int i =0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}