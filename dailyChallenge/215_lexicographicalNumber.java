// https://leetcode.com/problems/lexicographical-numbers/

class Solution {
    public List<Integer> lexicalOrder(int n) {
        String[] nums = new String[n];

        for(int i=0;i<n;i++){
            nums[i] = Integer.toString(i+1);
        }

        Arrays.sort(nums,(a,b)->a.compareTo(b));

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(Integer.parseInt(nums[i]));
        }

        return res;
    }
}