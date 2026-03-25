class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int row = grid.length;
        int cols = grid[0].length;

        //compute if its even or odd, so take total first;
        long total=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                total+=grid[i][j];
            }
        }
        if(total%2!=0) return false;

        long sum1=0,sum2=0;
        for(int k = 0;k<row-1;k++){
            for(int j=0;j<cols;j++){
                sum1+=grid[k][j];
            }
            sum2=total-sum1;
            if(sum1==sum2) return true;
        }

        sum1=0; sum2=0;
        for(int k = 0;k<cols-1;k++){
            for(int i=0;i<row;i++){
                sum1+=grid[i][k];
            }
            sum2=total-sum1;
            if(sum1==sum2) return true;
        }

        return false;
    }
}