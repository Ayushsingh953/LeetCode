// https://leetcode.com/problems/find-words-containing-character/

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> s=new ArrayList<Integer>();
        String st="";
        st+=x;
        for(int i=0;i<words.length;i++){
            if(words[i].contains(st)){
                s.add(i);
            }
        }
        return s;
    }
}

