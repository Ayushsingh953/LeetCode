// https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0,highest=0;
        for(int i=0;i<gain.length;i++){
            alt+=gain[i];
            highest = Math.max(highest,alt);
        }
        return highest;
    }
}