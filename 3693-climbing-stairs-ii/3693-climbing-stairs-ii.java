class Solution {
    public int helper(int j, int[] costs, int[] dp){
        if(j == 0) return 0;
        if(dp[j] !=-1) return dp[j];

        int best = Integer.MAX_VALUE;
        for(int k = 1 ; k <= 3 ; k++){
            if(j-k >= 0){
                best = Math.min(best,helper(j-k,costs,dp) + k*k);
            }
        }

        return dp[j] = best + costs[j-1];
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return helper(n,costs,dp);

        dp[0] = 0;

        for(int j=1;j<=n;j++){
            int best = Integer.MAX_VALUE;

            for(int k=1; k<=3; k++){
                if(j-k >= 0 ){
                    best = Math.min(best,dp[j-k] + k*k);
                }
            }

            dp[j] = best + costs[j-1];
        }

        return dp[n];
    }
}