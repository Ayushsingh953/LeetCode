// https://leetcode.com/problems/rank-transform-of-an-array/

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = new int[arr.length];
        int i=0;
        for(int num:arr){
            sorted[i++] = num;
        }

        Arrays.sort(sorted);
        Map<Integer,Integer> m = new HashMap<>();
        int rank=1;
        for(i=0;i<arr.length;i++){
            if(i>0 && sorted[i]!=sorted[i-1]){
                rank++;
            }
            m.put(sorted[i],rank);
        }

        for(i=0;i<arr.length;i++){
            arr[i] = m.get(arr[i]);
        }

        return arr;
    }
}