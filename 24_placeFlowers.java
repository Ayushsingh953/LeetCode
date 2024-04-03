// https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len=flowerbed.length;
        if(len==1){
            return flowerbed[0]==0 || n==0?true:false;
        }
        for(int i=0;i<flowerbed.length;i++){
            if(i==0){
                if(i+1<len && flowerbed[i]==0 && flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
                }
            }else if(i==len-1 ){
                if(i-1>=0 && flowerbed[i]==0 && flowerbed[i-1]==0){
                flowerbed[i]=1;
                n--;
                }
            }else{
                if(flowerbed[i-1]==0 && flowerbed[i+1]==0 && flowerbed[i]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        return n<=0?true:false;
    }
}