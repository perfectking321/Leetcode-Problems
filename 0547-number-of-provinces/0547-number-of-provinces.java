class Solution {
    public int findCircleNum(int[][] isConnected) {
        int node = isConnected.length;
        List<List<Integer>> isConnectedList = new ArrayList<>();
        for(int i=0;i<node;i++){
            isConnectedList.add(new ArrayList<>());
        }
        //convert the matrix to list
        for(int i=0;i<node;i++){
            for(int j=0;j<node;j++){
                if(isConnected[i][j]==1 && i!=j && i<j){
                    isConnectedList.get(i).add(j);
                    isConnectedList.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[node];
        int count = 0;
        //traverse
        for(int i=0;i<node;i++){
            if(!visited[i]){
                count++;
            dfs(i,isConnectedList,visited);
            }
        }
        return count;
    }
    public void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node] = true;
        for(int u:adj.get(node)){
            if(!visited[u]){
                dfs(u,adj,visited);
            }
        }
    }
}