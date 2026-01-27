class Solution {
    public int findCircleNum(int[][] isConnected) {
        //Vertices
        int v = isConnected.length;
        //Creating a list for that matrix
        List<List<Integer>> isConnectedList = new ArrayList<>();
        //Initialising this list
        for(int i=0;i<v;i++){
            isConnectedList.add(new ArrayList<>());
        }
        //Convert the current matrix to a list
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                //ignoring self loops
                if(isConnected[i][j]==1 && i!=j){
                    isConnectedList.get(i).add(j);
                    isConnectedList.get(j).add(i);
                }
            }
        }
        //Visited array to track the visited nodes
        boolean[] visited = new boolean[v];
        int count = 0;
        //traverse to all nodes
        for(int i = 0;i<v;i++){
            if(!visited[i]){
                count++;
                dfs(i,isConnectedList,visited);
            }
        }
        return count;
    }
    public void dfs(int v, List<List<Integer>> adj, boolean[] visited){
        visited[v] = true;
        for(int u: adj.get(v)){
            if(!visited[u]){
                dfs(u,adj,visited);
            }
        }
    }
}