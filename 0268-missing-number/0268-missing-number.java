class Solution {
    public int missingNumber(int[] nums) {
        int N = nums.length;
        int sum = (N * (N + 1)) / 2;

        // Calculate the sum of elements in the array
        int actualSum = 0;
        for (int i = 0; i < N; i++) {
            actualSum += nums[i];
        }

        // Missing number is the difference
        return sum - actualSum;
    }
}