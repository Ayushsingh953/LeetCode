// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int sum = 0;
        int temp = k;
        for(int i=0;i<n;i++){
            sum+=chalk[i];
            temp-=chalk[i];
            if(temp<0) return i;
        }
        int rem = k%sum;
        for(int i=0;i<n;i++){
            rem-=chalk[i];
            if(rem<0) return i;
        }
        return 0;
    }
}