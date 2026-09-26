class Solution {
public:
    int helper(int idx,int prev_idx,vector<int>& nums,vector<vector<int>>& dp){
        int n = nums.size();
        if(idx == n){
            return 0;
        }
        //coordinate shifting in prev_idx
        if(dp[idx][prev_idx+1] != -1){
            return dp[idx][prev_idx+1];
        }

        int len = 0 + helper(idx+1,prev_idx,nums,dp);
        if(prev_idx == -1 || nums[idx]>nums[prev_idx]){
            len = max(len,1+helper(idx+1,idx,nums,dp));
        }

        return dp[idx][prev_idx+1] = len;
    }
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n+1,vector<int> (n+1,0));

        //return helper(0,-1,nums,dp);

        for(int idx = n-1; idx>=0;idx--){
            for(int prev = idx-1;prev>=-1;prev--){
                int len = 0 + dp[idx+1][prev+1];
                if(prev == -1 || nums[idx] > nums[prev]){
                    len = max(len,1+dp[idx+1][idx+1]);
                }
                dp[idx][prev+1] = len;
            }
            
        }

        return dp[0][0];
    }
};