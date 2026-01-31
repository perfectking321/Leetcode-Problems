class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        // create queue for bfs
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //traverse only boundary
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1 && !vis[i][j]){
                        vis[i][j]=true;
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        //now start bfs traversal
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];
            //explore 4 directions
            for(int i=0;i<4;i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                //check boundary conditions, unvisited lands
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]) cnt++;
            }
        }
        return cnt;
    }
}