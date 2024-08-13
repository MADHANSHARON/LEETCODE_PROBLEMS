class Solution {
    public int jump(int[] nums) {
       int max=0,count=0,tempmax=0;
       for(int i=0;i<nums.length-1;i++){
           max=Math.max(max,i+nums[i]);
           if(max>=nums.length-1){
            count++;
            break;
           }
           if(tempmax==i){
            count++;
            tempmax=max;
           }
       } 
       return count;
    }
}