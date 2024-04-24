// https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        return (str1+str2).equals(str2+str1)?
        str1.substring(0,gcd(str1.length(),str2.length())):"";
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
class Solution2 {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()<str2.length()){
            return gcdOfStrings(str2,str1);
        }
       else if(!str1.startsWith(str2)){
            return "";
        }
       else if(str2.isEmpty()){
            return str1;
        }else
            return gcdOfStrings(str1.substring(str2.length()),str2);
    }
}