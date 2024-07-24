// https://leetcode.com/problems/sort-the-jumbled-numbers/


// Using custom sort
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] mappedVal = new int[n];
        Integer[] indices = new Integer[n];
        int[] sortedNum = new int[n];

        for(int i=0;i<n;i++) indices[i] = i;

        for(int i=0;i<n;i++){
            String number = Integer.toString(nums[i]);
            String st = "";
            for(int j=0;j<number.length();j++){
                st+=Integer.toString(mapping[number.charAt(j)-'0']);
            }
            mappedVal[i] = Integer.parseInt(st);
        }
        Arrays.sort(indices,(a,b)->mappedVal[a]-mappedVal[b]);
        int i=0;
        for(int indice:indices){
            sortedNum[i++] = nums[indice];
        }
        return sortedNum;
        
    }
}

// Using merge sort
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] mappedVal = new int[n];
       
        for(int i=0;i<n;i++){
            String number = Integer.toString(nums[i]);
            String st = "";
            for(int j=0;j<number.length();j++){
                st+=Integer.toString(mapping[number.charAt(j)-'0']);
            }
            mappedVal[i] = Integer.parseInt(st);
        }
        mergesort(nums,mappedVal,0,n-1);
        return nums;
    }
    public void mergesort(int[] nums,int[] map,int start,int end){
        if(start>=end) return;

        int mid = start+(end-start)/2;
        mergesort(nums,map,start,mid);
        mergesort(nums,map,mid+1,end);
        merge(nums,map,start,mid,end);
    }

    public void merge(int[] nums,int[] map,int start,int mid,int end){
        int l = mid-start+1;
        int r = end-mid;

        int[] leftArray = new int[l];
        int[] rightArray = new int[r];
        int[] leftMap = new int[l];
        int[] rightMap = new int[r];

        for(int i=0;i<l;i++){
            leftArray[i] = nums[start+i];
            leftMap[i] = map[start+i];
        }
        for(int j=0;j<r;j++){
            rightArray[j] = nums[mid+1+j];
            rightMap[j] = map[mid+1+j];
        }
        int i=0,j=0,k=start;

        while(i<l && j<r){
            if(leftMap[i]<=rightMap[j]){
                map[k] = leftMap[i];
                nums[k] = leftArray[i];
                i++;
            }else{
                map[k] = rightMap[j];
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i<l){
            map[k] = leftMap[i];
            nums[k++] = leftArray[i++];
        }
        while(j<r){
            map[k] = rightMap[j];
            nums[k++] = rightArray[j++];
        }
    }
}