// https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s=new HashSet<Integer>();
        List<Integer> res=new ArrayList<Integer>();
        for(int num:nums1){
            s.add(num);
        }
        for(int num:nums2){
            if(s.contains(num) && !res.contains(num)){
                res.add(num);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}