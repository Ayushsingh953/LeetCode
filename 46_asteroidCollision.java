// https://leetcode.com/problems/asteroid-collision/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int len = asteroids.length;
        int[] size = new int[len];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<len;i++){
            size[i] = Math.abs(asteroids[i]);
        }
        for(int i=0;i<len;i++){
            if(asteroids[i]>0){
                s.push(i);
            }else{
                while(!s.isEmpty() && size[i]>0){
                    int topIdx = s.pop();
                    if(size[topIdx]>size[i]){
                        size[i]=0;
                        s.push(topIdx);
                    }
                    else if(size[topIdx]<size[i]){
                        size[topIdx]=0;
                    }else{
                        size[i]=0;
                        size[topIdx]=0;
                    }
                }
            }
        }
        for(int i=0;i<len;i++){
            if(size[i]!=0){
                res.add(asteroids[i]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}