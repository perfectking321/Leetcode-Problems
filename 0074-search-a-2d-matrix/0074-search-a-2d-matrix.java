class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0,high=n*m-1;
        while(low<=high){
            // calculate middle index for binary search
            int mid=(low+high)/2;
            //1d array index of 2d array coordinates
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}