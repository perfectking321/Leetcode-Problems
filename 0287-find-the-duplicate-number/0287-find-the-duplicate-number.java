class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        // first detect a cycle
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        } while(slow!=fast);
        // init fast to first index then find index where cycle begins
        fast = nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}