class Solution {
    public int helper(int idx,int[] nums,int[] dp){
        //base
        if(idx == 0){
            return nums[idx];
        }
        if(idx<0){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        //take notTake case
        int take = nums[idx] ;
        if(idx>1){
            take += helper(idx-2,nums,dp);
        }

        //notTake
        int notTake = helper(idx-1,nums,dp);

        return dp[idx] = Math.max(take,notTake);

    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1,nums,dp);
    }
}