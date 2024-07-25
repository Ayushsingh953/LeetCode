// https://leetcode.com/problems/sort-an-array/

class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }
    public void mergesort(int[] nums,int start,int end){
        if(start>=end) return;

        int mid = start+(end-start)/2;
        mergesort(nums,start,mid);
        mergesort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    public void merge(int[] nums,int start,int mid,int end){
        int l =  mid-start+1;
        int r = end-mid;

        int[] leftArray = new int[l];
        int[] rightArray = new int[r];

        for(int i=0;i<l;i++){
            leftArray[i] = nums[start+i];
        }

        for(int j=0;j<r;j++){
            rightArray[j] = nums[mid+1+j];
        }

        int i=0,j=0,k=start;
        while(i<l && j<r){
            if(leftArray[i]<=rightArray[j]){
                nums[k] = leftArray[i++];
            }else{
                nums[k] = rightArray[j++];
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