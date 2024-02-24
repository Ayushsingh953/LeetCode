// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

class Solution {
    public int mostWordsFound(String[] sentences) {
        int count,max=0;
        for(int i=0;i<sentences.length;i++){
            count=0;
            for(int j=0;j<sentences[i].length();j++){
                if(sentences[i].charAt(j)==' '){
                    count++;
                }
            }
            max=Math.max(max,count);
        }
        return max+1;
    }
}