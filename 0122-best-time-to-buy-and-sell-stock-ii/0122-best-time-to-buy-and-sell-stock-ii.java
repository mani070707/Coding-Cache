class Solution {
    long helper(int idx,int buy, int[] prices,long[][] dp){
        int n = prices.length;
        if(idx == n){
            return 0;
        }
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }
        long profit = 0;
        //buyed now u call either take n sell or notTake then sell on another idx
        if(buy == 1){
            profit = Math.max(-prices[idx] + helper(idx+1,0,prices,dp),0+helper(idx+1,1,prices,dp));
        }
        //selled now u can sell n buy or not sell then sell on next idx
        else{
            profit = Math.max(prices[idx] + helper(idx+1,1,prices,dp),0+helper(idx+1,0,prices,dp));
        }

        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // long[][] dp = new long[n+1][2];
        // for(long[] d : dp){
        //     Arrays.fill(d,0);
        // }
        //here in memo we are going from 0-n-1
        //return (int)helper(0,1,prices,dp);

        //tabulation
        //convert the base 
        //look for the changing parameters
        //copy the recurrence

        // in tabu we go n to 0 so dp will be n+1

        // dp[n][0] = dp[n][1] = 0;
        long[] ahead =new long[2];
        long[] curr = new long[2];

        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                long profit = 0;
                //buyed now u call either take n sell or notTake then sell on another idx
                if(buy == 1){
                    profit = Math.max(-prices[idx] + ahead[0],0 + ahead[1]);
                }
                //selled now u can sell n buy or not sell then sell on next idx
                else{
                    profit = Math.max(prices[idx] + ahead[1],0 + ahead[0]);
                }
                
                curr[buy] = profit;

            }
            ahead = curr;
        }

        return (int)ahead[1];

    }
}