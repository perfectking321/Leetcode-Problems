class Solution {
    public int removeDuplicates(int[] nums) {
        //stores unique elemets which we seen
        HashSet<Integer> seen = new HashSet<>();
        //position to overwrite next unique element
        int index=0;
        for(int num: nums){
            //unique elements
            if(!seen.contains(num)){
                seen.add(num);
                nums[index] = num;
                index++;
            }
        }
        return index;
    }
}