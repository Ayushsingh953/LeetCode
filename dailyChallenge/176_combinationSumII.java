// https://leetcode.com/problems/combination-sum-ii/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,subset,res,0,target);
        return res;
    }

    public void backtrack(int[] ar,List<Integer> subset,List<List<Integer>> res,int idx,int sum){
        if(sum<0) return;
        else if(sum==0){
            res.add(new ArrayList<>(subset));
        }else{
            for(int i=idx;i<ar.length && sum>=ar[i];i++){
                if(i>idx && ar[i]==ar[i-1]) continue;
                subset.add(ar[i]);

                backtrack(ar,subset,res,i+1,sum-ar[i]);
                subset.remove(subset.size()-1);
            }
        }
    }
}