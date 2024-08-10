class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
        for(int i:nums){
            if(count<2 || i!=nums[count-2]){
                nums[count]=i;
                count++;
            }
            
        }
        return count;
    }
}