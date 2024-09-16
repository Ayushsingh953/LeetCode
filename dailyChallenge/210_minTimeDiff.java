// https://leetcode.com/problems/minimum-time-difference/

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] points = new int[n];
        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            String time = timePoints.get(i);
            int hour = (time.charAt(0)-'0')*10+(time.charAt(1)-'0');
            int minute = (time.charAt(3)-'0')*10+(time.charAt(4)-'0');
            if(hour==0){
                points[i] = 24*60+minute;
            }else{
                points[i] = hour*60+minute;
            }
        }
        Arrays.sort(points);
        for(int i=0;i<n-1;i++){
            if(points[i+1]-points[i]<minDiff){
                minDiff = points[i+1]-points[i];
            }
        }
        return Math.min(
            minDiff,
            24 * 60 - points[n - 1] + points[0]
        );
    }
}