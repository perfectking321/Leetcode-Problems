class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = new int[image.length][image[0].length];
        //copy original image to ans
        for(int i = 0;i<image.length;i++){
            ans[i]=Arrays.copyOf(image[i],image[i].length);
        }
        //delta array to explore 4 directions
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        dfs(sr,sc,ans,image,color,delRow,delCol,iniColor);
        return ans;
    }
    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol, int iniColor){
        // color the current pixel with new color
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        //explore all 4 neighbors(up,right,down,left)
        for(int i =0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            // Check for valid coordinates and same initial color
            // Also ensure the pixel is not already colored with newColor
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol <m && image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor){
                dfs(nrow,ncol,ans,image,newColor,delRow,delCol,iniColor);
            }
        }
    }
}