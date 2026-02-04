class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Queue<Pair<Integer, Pair<Integer,Integer>>> q = new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        // int m=grid[0].size();
        // List<List<Integer>> dist = new ArrayList<>(m,1e9);
        //if start or end is blocked
        if(grid[0][0]==1 || grid[n-1][n-1] == 1){
            return -1;
        }
        //8 directions
        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0]=1;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            int dist = cell[2];
            //reached destination
            if(row==n-1 && col==n-1){
                return dist;
            }
            //explore 8 directions
            for(int i=0;i<8;i++){
                int nr=row+directions[i][0];
                int nc=col+directions[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==0){
                    q.offer(new int[]{nr,nc,dist+1});
                    grid[nr][nc]=1;
                }
            }
        }
        return -1;
    }
}