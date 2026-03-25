class Solution {
    public int largestSubmatrix(int[][] matrix) {
        //greedy algorithm+
        int m =matrix.length;
        int n =matrix[0].length;
        int res=0;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]+= matrix[i-1][j];
                }
            }
        }
        for(int i=0;i<m;i++){
            int[] row = matrix[i].clone();
            Arrays.sort(row);
            for(int j=0;j<n;j++){
                if(row[j]==0) continue;
                int height = row[j];
                int width=n-j;
                res=Math.max(res, height * width);
            }
        }
        return res;
    }
}