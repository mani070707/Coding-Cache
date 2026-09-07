class Solution {
    public int helper(int idx,int[] dp){
        //base case
        if(idx <= 1){
            return 1;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }

        return dp[idx] = helper(idx-1,dp) + helper(idx-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // return helper(n,dp);
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}