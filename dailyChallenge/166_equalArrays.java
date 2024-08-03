// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/


// Using sorting
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=target[i]) return false;
        }
        return true;
    }
}

// Using hashMap
class Solution2 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=target[i]) return false;
        }
        return true;
    }
}