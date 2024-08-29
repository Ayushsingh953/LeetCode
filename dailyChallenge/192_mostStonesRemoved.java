// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        List<Integer>[] adjacencyList = new List[n];
        for(int i=0;i<n;i++){
            adjacencyList[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    adjacencyList[i].add(j);
                    adjacencyList[j].add(i);
                }
            }
        }
        int connected = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(adjacencyList,visited,i);
                connected++;
            }
        }
        return n-connected;
    }

    public void dfs(List<Integer>[] adjacencyList,boolean[] visited,int stone){
        visited[stone] = true;

        for(int neighbor:adjacencyList[stone]){
            if(!visited[neighbor]){
                dfs(adjacencyList,visited,neighbor);
            }
        }
    }
}