// https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {
    int k;
    List<Integer> stream;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        stream = new ArrayList<>(nums.length);

        for(int num:nums){
            stream.add(num);
        }    

        Collections.sort(stream);
    }
    
    public int add(int val) {
        int idx = findIndex(val);

        stream.add(idx,val);

        int KthLargest = stream.get(stream.size()-k);
        return KthLargest;
    }

    public int findIndex(int val){
        int left = 0;
        int right = stream.size()-1;

        while(left<=right){
            int mid = (left+right)/2;
            int ele = stream.get(mid);

            if(ele==val){
                return mid;
            }
            if(ele>val){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}

