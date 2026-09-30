class Solution {
    public int helper(int idx,int prev_idx,int[] nums,int[][] dp){
        int n = nums.length;

        //base case
        if(idx == n){
            return 0;
        }

        //overlap case
        if(dp[idx][prev_idx+1] != -1){
            return dp[idx][prev_idx+1];
        }

        //recur
        //skip
        int len = 0 + helper(idx+1,prev_idx,nums,dp);
        //take
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]){
            len = Math.max(len,1 + helper(idx+1,idx,nums,dp));
        }

        return dp[idx][prev_idx+1] = len;

    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(0,-1,nums,dp);
    }
}