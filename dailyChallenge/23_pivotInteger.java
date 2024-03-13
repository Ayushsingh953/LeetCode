// https://leetcode.com/problems/find-the-pivot-integer/

class Solution {
    public int pivotInteger(int n) {
        int l=2,r=n-1,leftSum=1,rightSum=n;
        if(leftSum==rightSum){
            return leftSum;
        }
        while(l<=r){
            if(leftSum==rightSum && l==r){
                return l;
            }
            else if(leftSum<rightSum){
                leftSum+=l;
                l++;
            }else{
                rightSum+=r;
                r--;
            }
        }
        return -1;
    }
}

//Using mathematics

class Solution2 {
    public int pivotInteger(int n) {
       int sum=(n*(n+1))/2;
       int x=(int)Math.sqrt(sum);
       if((x*x)==sum){
        return x;
       }
       return -1;
    }
}