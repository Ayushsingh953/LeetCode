// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subArraySum = new ArrayList<>();
        int res = 0,mod = (int)1e9+7;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                subArraySum.add(sum);
            }
        }
        Collections.sort(subArraySum);
        for(int i=left;i<=right;i++){
            res = (res+subArraySum.get(i-1))%mod;
        }
        return res;
    }
}