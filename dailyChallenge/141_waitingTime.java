// https://leetcode.com/problems/average-waiting-time/

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int totalTime = customers[0][0] + customers[0][1];
        double waitingTime = customers[0][1];
        for(int i=1;i<customers.length;i++){
            if(customers[i][0]<totalTime){
                totalTime+=customers[i][1];
            }else{
                 totalTime+=(customers[i][0]-totalTime)+customers[i][1];
            }
            waitingTime += totalTime-customers[i][0];
        }
        return waitingTime/customers.length;
    }
}

class Solution2 {
    public double averageWaitingTime(int[][] customers) {
        int totalTime  = 0;
        double waitingTime = 0;
        for(int i=0;i<customers.length;i++){
            totalTime=Math.max(totalTime,customers[i][0])+customers[i][1];   
            waitingTime += totalTime-customers[i][0];
        }
        return waitingTime/customers.length;
    }
}