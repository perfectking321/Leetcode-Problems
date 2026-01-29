class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // Check if 0 is missing
        if(nums[0] != 0) return 0;
        
        // Check middle numbers
        for(int i = 1; i < n; i++){
            if(nums[i] != i){
                return i;
            }
        }
        
        // If no number is missing in 0 to n-1, then n is missing
        return n;
    }
}