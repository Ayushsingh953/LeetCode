// https://leetcode.com/problems/compare-version-numbers/

class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int i=0,j=0;
        while(i<len1 || j<len2){
            int lev1=0;
            int lev2=0;
            while(i<len1 && version1.charAt(i)!='.'){
                lev1 = lev1*10+version1.charAt(i)-'0';
                i++;
            }
            while(j<len2 && version2.charAt(j)!='.'){
                lev2 = lev2*10+version2.charAt(j)-'0';
                j++;
            }
            if(lev1<lev2) return -1;
            else if(lev1>lev2) return 1;
            i++;
            j++;
        }
        return 0;
    }
}

class Solution2 {
    public int compareVersion(String version1, String version2) {
       String[] level1 = version1.split("\\.");
       String[] level2 = version2.split("\\.");

       int len = Math.max(level1.length,level2.length);
       for(int i = 0;i<len;i++){
        int val1 = i<level1.length ? Integer.parseInt(level1[i]) : 0;
        int val2 = i<level2.length ? Integer.parseInt(level2[i]) : 0;

        if(val1<val2) return -1;
        else if(val1>val2) return 1;
       }
       return 0;
    }
}