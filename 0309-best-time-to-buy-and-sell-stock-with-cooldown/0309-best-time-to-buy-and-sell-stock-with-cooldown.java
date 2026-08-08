class Solution {
    public int helper(int idx,int buy,int n , int[] prices,int[][] dp){
        if(idx >= n){
            return 0;
        }

        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[idx] + helper(idx+1,0,n,prices,dp),0+helper(idx+1,1,n,prices,dp));
        }
        else{
            profit = Math.max(prices[idx] + helper(idx+2,1,n,prices,dp),0+helper(idx+1,0,n,prices,dp));
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }

        return helper(0,1,n,prices,dp);
    }
}