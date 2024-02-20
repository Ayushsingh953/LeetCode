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

class Solutions {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> s=new ArrayList<Integer>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(words[i].charAt(j)==x){
                    s.add(i);
                    break;
                }
            }
        }
        return s;
    }
}