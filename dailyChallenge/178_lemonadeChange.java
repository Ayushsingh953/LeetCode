// https://leetcode.com/problems/lemonade-change/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveChange = 0;
        int tenChange = 0;

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                fiveChange++;
            }
            else if(bills[i]==10){
                if(fiveChange>0){
                    fiveChange--;
                    tenChange++;
                }else{
                    return false;
                }
            }
            else{
               if(tenChange>0 && fiveChange>0){
                tenChange--;
                fiveChange--;
               }
               else if(fiveChange>=3){
                fiveChange-=3;
               }else{
                return false;
               }
            }
        }
        return true;
    }
}