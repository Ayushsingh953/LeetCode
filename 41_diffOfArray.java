// https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();
        for(int val:nums1){
            n1.add(val);
        }
        for(int val:nums2){
            n2.add(val);
        }
        for(int val:n1){
            if(!n2.contains(val)){
                ans.get(0).add(val);
            }
        }
        for(int val:n2){
            if(!n1.contains(val)){
                ans.get(1).add(val);
            }
        }
        return ans;
    }
}