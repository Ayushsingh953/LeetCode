// https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int compress(char[] chars) {
        char ch = chars[0];
        int len = chars.length;
        int count = 1;
        String st=""+ch;
        for(int i=1;i<len;i++){
            if(chars[i] == ch){
                count++;
                continue;
            }
            if(count != 1){
                st+=count;
            }
            count = 1;
            ch = chars[i];
            st+=ch;
        }
        if(count!=1) st+=count;
        System.out.println(st);
        for(int i = 0;i<st.length();i++){
            chars[i] = st.charAt(i);
        }
        return st.length();
    }
}

class Solution2 {
    public int compress(char[] chars) {
       int idx = 0,idxAns=0;
       while(idx<chars.length){
            char ch = chars[idx];
            int count = 0;
            while(idx<chars.length && chars[idx] == ch){
                idx++;
                count++;
            }
            chars[idxAns++] = ch;
            if(count!=1){
                for(char c:Integer.toString(count).toCharArray()){
                    chars[idxAns++] = c;
                }
            }
       }
       return idxAns;
    }
}