// https://leetcode.com/problems/find-the-town-judge/?envType=daily-question&envId=2024-02-22

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts=new int[n+1];
        int[] trusted=new int[n+1];
        for(int[] i:trust){
            trusts[i[0]]++;
            trusted[i[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(trusts[i]==0 && trusted[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}