// https://leetcode.com/problems/first-missing-positive/


// Using set
class Solution1 {
    public int firstMissingPositive(int[] nums) {
         Set<Integer> s=new HashSet<>();
         int n=nums.length;
         for(int i=0;i<n;i++){
            if(nums[i]>0){
                s.add(nums[i]);
            }
         }
         for(int i=1;i<=n;i++){
            if(!s.contains(i)){
                return i;
            }
         }
         return n+1;
    }
}

// Optimized solution
//Using cyclic sort
class Solution2 {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int i=0;

        while(i<n){
            int idx=nums[i]-1;
            if(nums[i]>0 && nums[i]<n && nums[i]!=nums[idx]){
                swap(nums,i,idx);
            }else{
                i++;
            }
        }

        for(i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

    public void swap(int arr[],int i,int j){
        arr[i]=arr[i]^arr[j]^(arr[j]=arr[i]);
    }
}