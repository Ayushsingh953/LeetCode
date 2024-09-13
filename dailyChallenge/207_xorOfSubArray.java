// https://leetcode.com/problems/xor-queries-of-a-subarray/


// brute force
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int xor = 0;
            for(int j=left;j<=right;j++){
                xor^=arr[j];
            }
            answer[i] = xor;
        }

        return answer;
    }
}

// Using running XOR
class Solution2 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] runningXor = new int[arr.length];
        int xor = 0;
        
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            runningXor[i] = xor;
        }


        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            if(left==0){
                answer[i] = runningXor[right];
            }else{
                answer[i] = runningXor[right]^runningXor[left-1];
            }
        }
        
        return answer;
    }
}