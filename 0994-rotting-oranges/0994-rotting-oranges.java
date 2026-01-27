class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int count = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                //count all total orange
                if(grid[i][j] != 0) total++;
                //add rotten to queue
                if(grid[i][j] == 2){
                    rotten.add(new int[]{i,j});
                }
            }
        }
        //arrays for direction vectors(up,down,right,left)
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        //track time
        int time = 0;
        //bfs loop to rot oranges level by level
        while(!rotten.isEmpty()){
            //number of rotten oranges to process in this level
            int k = rotten.size();
            //add count to rotten oranges
            count += k;
            //process each rotten orange
            for(int i =0;i<k;i++){
                int[] pos = rotten.poll();
                int x = pos[0],y=pos[1];

                //Check all 4 directions
                for(int d = 0;d<4;d++){
                    int nx = x+dx[d];
                    int ny = y+dy[d];

                    //skip out of bounds or non fresh cells
                    if(nx<0 || ny<0 || nx>=m || ny >= n || grid[nx][ny] != 1){
                        continue;
                    }
                    //Mark orange as rotten
                    grid[nx][ny] = 2;
                    //Add new rotten orange to queue
                    rotten.add(new int[]{nx,ny});
                }
            }
            //Only increse time if we have new oranges to process
            if(!rotten.isEmpty()) time++;
        }
        //if all oranges are rotted return time or else return -1
        return total == count ? time : -1;
    }
}