// https://leetcode.com/problems/find-the-winner-of-the-circular-game/

// simulation
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> circle = new ArrayList<>();
        for(int i=1;i<=n;i++){
            circle.add(i);
        }
        int startIndex = 0;
        while(circle.size()>1){
            int removeIdx = (startIndex+k-1) % circle.size();
            circle.remove(removeIdx);
            startIndex = removeIdx;
        }
        return circle.getFirst();
    }
}

// recusrion
class Solution2 {
    public int findTheWinner(int n, int k) {
        return helper(n,k)+1;
    }
    public int helper(int n,int k){
        if(n==1){
            return 0;
        }
        return (helper(n-1,k)+k)%n;
    }
}