// https://leetcode.com/problems/robot-collisions/

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        Integer indices[] = new Integer[n];

        for(int index =0;index<n;index++){
            indices[index]=index;
        }
        Arrays.sort(indices,(lhs,rhs)->Integer.compare(positions[lhs],positions[rhs]));
        for(int i:indices){
            if(directions.charAt(i)=='R'){
                s.push(i);
            }else{
                while(!s.isEmpty() && healths[i]>0){
                    int topIdx = s.pop();
                    if(healths[topIdx]>healths[i]){
                        healths[i]=0;
                        healths[topIdx]-=1;
                        s.push(topIdx);
                    }
                    else if(healths[topIdx]<healths[i]){
                        healths[topIdx]=0;
                        healths[i]-=1;
                    }else{
                        healths[topIdx]=0;
                        healths[i]=0;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(healths[i]>0){
                res.add(healths[i]);
            }
        }
        return res;
    }
}