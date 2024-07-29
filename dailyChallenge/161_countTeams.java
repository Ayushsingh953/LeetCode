// https://leetcode.com/problems/count-number-of-teams/

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams = 0;

        Integer[][] increasingCache = new Integer[n][4];
        Integer[][] decreasingCache = new Integer[n][4];

        for(int i=0;i<n;i++){
            teams+=countIncreasing(rating,i,1,increasingCache)+
                   countDecreasing(rating,i,1,decreasingCache);
        }

        return teams;
    }

    public int countIncreasing(int[] rating,int curIdx,int teamSize,Integer[][] increasingCache){
        if(curIdx==rating.length) return 0;

        if(teamSize==3) return 1;

        if(increasingCache[curIdx][teamSize]!=null){
            return increasingCache[curIdx][teamSize];
        }
        int validTeams = 0;
        for(int nextIdx=curIdx+1;nextIdx<rating.length;nextIdx++){
            if(rating[nextIdx]>rating[curIdx]){
                validTeams+=countIncreasing(rating,nextIdx,teamSize+1,increasingCache);
            }
        }
        return increasingCache[curIdx][teamSize] = validTeams;
    }

    public int countDecreasing(int[] rating,int curIdx,int teamSize,Integer[][] decreasingCache){
        if(curIdx==rating.length) return 0;

        if(teamSize==3) return 1;

        if(decreasingCache[curIdx][teamSize]!=null){
            return decreasingCache[curIdx][teamSize];
        }
        int validTeams = 0;
        for(int nextIdx=curIdx+1;nextIdx<rating.length;nextIdx++){
            if(rating[nextIdx]<rating[curIdx]){
                validTeams+=countDecreasing(rating,nextIdx,teamSize+1,decreasingCache);
            }
        }
        return decreasingCache[curIdx][teamSize] = validTeams;
    }
}