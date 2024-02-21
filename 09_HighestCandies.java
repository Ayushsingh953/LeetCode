// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result=new ArrayList<Boolean>();
        int max=0;
        for(int i=0;i<candies.length;i++){
            max=Math.max(max,candies[i]);
        }

        for(int i=0;i<candies.length;i++){
            if((candies[i]+extraCandies)>=max){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}