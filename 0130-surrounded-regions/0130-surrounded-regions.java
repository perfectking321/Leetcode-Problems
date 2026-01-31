class Solution {

    public void solve(char[][] board) {
        // creating variable
        int n = board.length;
        int m = board[0].length;
        // direction vectors rows and coloums
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        // creating another array for marking them visited
        int[][] vis = new int[n][m];
        // now check boundaries to check 'O' and then DFS
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && board[0][j]=='O') dfs(0,j,vis,board,dr,dc);
            if(vis[n-1][j]==0 && board[n-1][j]=='O') dfs(n-1,j,vis,board,dr,dc);
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && board[i][0]=='O') dfs(i,0,vis,board,dr,dc);
            if(vis[i][m-1]==0 && board[i][m-1]=='O') dfs(i,m-1,vis,board,dr,dc);
        }
        //after getting all boundaries to visited == 1;
        //change the inner 'O' to 'X'
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }
    private void dfs(int row,int col,int[][] vis, char[][] mat, int[] delrow, int[] delcol){
        // making all the index visited
        vis[row][col]=1;
        // creating variables
        int n = mat.length;
        int m = mat[0].length;
        // traverse new row and new col with conditions
        for(int i = 0;i<4;i++){
            int nr = row + delrow[i];
            int nc = col + delcol[i];
            // boundary conditions and question conditions
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && mat[nr][nc]=='O'){
                dfs(nr,nc,vis,mat,delrow,delcol);
            }
        }
    }
}