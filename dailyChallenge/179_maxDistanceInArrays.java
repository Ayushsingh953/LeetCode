// https://leetcode.com/problems/maximum-distance-in-arrays/

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size()-1);
        int maxDistance = 0;
    
        for(int i=1;i<arrays.size();i++){

            List<Integer> ar = arrays.get(i);
            maxDistance = Math.max(maxDistance,Math.abs(ar.get(ar.size()-1)-minValue));
            maxDistance = Math.max(maxDistance,Math.abs(maxValue-ar.get(0)));
            minValue = Math.min(minValue,ar.get(0));
            maxValue = Math.max(maxValue,ar.get(ar.size()-1));            
        }    

        return maxDistance;
    }
}