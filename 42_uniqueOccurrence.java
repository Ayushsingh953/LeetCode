// https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> count=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            count.put(arr[i],count.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> s=new HashSet<>(count.values());
        return count.size()==s.size();
    }
}