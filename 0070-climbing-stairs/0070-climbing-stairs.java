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
        return helper(n,dp);
    }
}