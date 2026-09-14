class Solution {
    public int helper(int idx1, int idx2, String text1, String text2,int[][] dp){
        //base case
        if(idx1 == 0 || idx2 == 0){
            return 0;
        }
          //overlaping cases
        if(dp[idx1][idx2] !=-1){
            return dp[idx1][idx2];
        }
        if(text1.charAt(idx1-1) == text2.charAt(idx2-1)){
            return dp[idx1][idx2] = 1 + helper(idx1-1,idx2-1,text1,text2,dp);
        }

        return dp[idx1][idx2] = 0 + Math.max(helper(idx1-1,idx2,text1,text2,dp),helper(idx1,idx2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return helper(n,m,text1,text2,dp);

    }
}