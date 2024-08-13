class Solution {
    public boolean canJump(int[] nums) {
        int stepsleft=nums[0];
        int n=nums.length;
        if(n==1) return true;
        for(int i=0;i<nums.length;i++){
            
            stepsleft--;
            if(stepsleft<0){
                return false;
            }
            if(i==nums.length-1){
                return true;
            }
            if(stepsleft<nums[i]){
                stepsleft=nums[i];
            }
        }
        return true;
        
    }
}