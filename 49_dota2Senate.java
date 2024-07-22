// https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n= senate.length();

        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R'){
                rad.offer(i);
            }else{
                dire.offer(i);
            }
        }
        while(!rad.isEmpty() && !dire.isEmpty()){
            if(rad.poll()<dire.poll()){
                rad.offer(n++);
            }else{
                dire.offer(n++);
            }
        }
        return rad.isEmpty() ? "Dire" : "Radiant";
    }
}