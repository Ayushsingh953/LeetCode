// https://leetcode.com/problems/sort-array-by-increasing-frequency/

// Custom comparator
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        Integer[] numsObj = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            numsObj[i] = nums[i];
        }
        Arrays.sort(numsObj,(a,b)->{
            if(freq.get(a).equals(freq.get(b))){
                return Integer.compare(b,a);
            }
            return Integer.compare(freq.get(a),freq.get(b));
        });

        for(int i=0;i<nums.length;i++){
            nums[i] = numsObj[i];
        }
        return nums;
    }
}

// Using mergeasort
class Solution2 {
    public int[] frequencySort(int[] nums) {
       int[] freq = new int[201];
       for(int num:nums){
        freq[num+100]++;
       }
       mergesort(nums,freq,0,nums.length-1);
        return nums;
    }
    public void mergesort(int[] nums,int[] freq,int start,int end){
        if(start>=end) return;

        int mid = start+(end-start)/2;
        mergesort(nums,freq,start,mid);
        mergesort(nums,freq,mid+1,end);
        merge(nums,freq,start,mid,end);
    }
    public void merge(int[] nums,int[] freq,int start,int mid,int end){
        int l = mid-start+1;
        int r = end-mid;

        int[] leftArray = new int[l];
        int[] rightArray = new int[r];
        for(int i=0;i<l;i++){
            leftArray[i] = nums[i+start];
        }
        for(int j=0;j<r;j++){
            rightArray[j] = nums[j+mid+1];
        }

        int i=0,j=0,k=start;
        while(i<l && j<r){
            if(freq[leftArray[i]+100]<freq[rightArray[j]+100]){
                nums[k] = leftArray[i];
                i++;
            }
            else if(freq[leftArray[i]+100]==freq[rightArray[j]+100]){
                if(leftArray[i]>rightArray[j]){
                    nums[k] = leftArray[i];
                    i++;
                }else{
                    nums[k] = rightArray[j];
                    j++;
                }
            }else{
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i<l){
            nums[k++] = leftArray[i++];
        }
        while(j<r){
            nums[k++] = rightArray[j++];
        }
    }
}