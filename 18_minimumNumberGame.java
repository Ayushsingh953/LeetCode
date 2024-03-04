// https://leetcode.com/problems/minimum-number-game/

class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i+=2){
            nums[i]=nums[i]^nums[i-1]^(nums[i-1]=nums[i]);
        }
        return nums;
    }
}

class Solution2 {
    public int[] numberGame(int[] nums) {
        sort(nums);
        for(int i=1;i<nums.length;i+=2){
            nums[i]=nums[i]^nums[i-1]^(nums[i-1]=nums[i]);
        }
        return nums;
    }

    public void sort(int[] arr){
        int[] count=new int[101];
        for(int num:arr){
            count[num]++;
        }
        int ind=0;
        for(int i=0;i<101;i++){
            while(count[i]-->0){
                arr[ind++]=i;
            }
        }
    }
}