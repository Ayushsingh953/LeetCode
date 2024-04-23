// https://leetcode.com/problems/minimum-height-trees/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return Collections.singletonList(0);
        }
        int[] degree = new int[n];
        Map<Integer,List<Integer>> adjList = new HashMap<>();

        for(int[] edge:edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            adjList.computeIfAbsent(edge[0],x -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1],x -> new ArrayList<>()).add(edge[0]);
        }
        Queue<Integer> leaves = new LinkedList<>();
        for(int i=0;i<degree.length;i++){
            if(degree[i] == 1){
                leaves.offer(i);
            }
        }
        int remainingNodes = n;
        while(remainingNodes>2){
            int size = leaves.size();
            remainingNodes-=size;
            for(int i=0;i<size;i++){
                int leaf = leaves.poll();
                for(int neighbor: adjList.get(leaf)){
                    if(--degree[neighbor] == 1){
                        leaves.offer(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>(leaves);
    }
}