// https://leetcode.com/problems/custom-sort-string/

class Solution {
    public String customSortString(String order, String s) {
        int[] ar=new int[26];
        for(int i=0;i<26;i++){
            ar[i]=27;
        }
        for(int i=0;i<order.length();i++){
            ar[order.charAt(i)-'a']=i;
        }
         Character[] charArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }
        Arrays.sort(charArray,new Comparator<Character>(){
             public int compare(Character c1, Character c2) {
            return ar[c1-'a']-ar[c2-'a'];
        }
        });
         StringBuilder str = new StringBuilder();
        for (char c : charArray) {
            str.append(c);
        }
        return str.toString();
    }
}