// https://leetcode.com/problems/find-if-path-exists-in-graph/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];

        for(int i = 0;i<n;i++){
            graph[i] = new HashSet<Integer>();
        }

        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        if(graph[source].contains(destination)){
            return true;
        }

        int current;
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;

        while(!q.isEmpty()){
            current = q.poll();
            if(current == destination){
                return true;
            }

            for(Integer neighbour:graph[current]){
                if(!visited[neighbour]){
                    q.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return false;
    }
}