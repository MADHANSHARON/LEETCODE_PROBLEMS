class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            else{
                int profit=prices[i]-min;
                if(max<profit){
                    max=profit;
                }
            }
        }
        return max;

    }
}