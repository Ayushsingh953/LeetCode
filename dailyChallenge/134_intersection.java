// https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        Stack<Integer> s=new Stack<Integer>();
       
        ArrayList<Integer> a=new ArrayList<Integer>();
       for(int i=0;i<len1;i++){
           for(int j=0;j<len2;j++){
               if((nums1[i]==nums2[j])&&!s.contains(j)){
                   a.add(nums1[i]);
                   s.push(j);
                   break;
               }
           }
       }
       return a.stream().mapToInt(i -> i).toArray();
    }
}