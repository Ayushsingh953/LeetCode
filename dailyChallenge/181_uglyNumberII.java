// https://leetcode.com/problems/ugly-number-ii/


// Using set
class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> s = new TreeSet<>();

        s.add(1L);
        long current = 1L;
        for(int i=0;i<n;i++){
            current = s.pollFirst();

            s.add(current*2);
            s.add(current*3);
            s.add(current*5);
        }

        return (int)current;
    }
}

// Using dp
class Solution2 {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int multipleOf2 = 2,multipleOf3 = 3,multipleOf5 = 5;
        int idxOf2 = 0,idxOf3 = 0,idxOf5 = 0;

        for(int i=1;i<n;i++){
            int nextUgly = Math.min(multipleOf2,Math.min(multipleOf3,multipleOf5));

            ugly[i] = nextUgly;
            if(nextUgly == multipleOf2){
                idxOf2++;
                multipleOf2 =  ugly[idxOf2]*2;
            }
            if(nextUgly == multipleOf3){
                idxOf3++;
                multipleOf3 =  ugly[idxOf3]*3;
            }
            if(nextUgly == multipleOf5){
                idxOf5++;
                multipleOf5 =  ugly[idxOf5]*5;
            }
        }
        return ugly[n-1];
    }
}