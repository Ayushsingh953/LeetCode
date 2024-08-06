// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

class Solution {
    public int minimumPushes(String word) {
        Integer[] freq = new Integer[26];
        for(int i=0;i<26;i++){
            freq[i] = 0;
        }

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            freq[ch-'a']++;
        }
        Arrays.sort(freq,Collections.reverseOrder());
        int pushes = 0,totalCost = 0;
        for(int i=0;i<26;i++){
            if(freq[i]==0) break;
            if(i%8==0) pushes++;
            totalCost+=pushes*freq[i];
        }
        return totalCost;
    }
}