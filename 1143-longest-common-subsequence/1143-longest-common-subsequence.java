class Solution {
    public int helper(int i,int j,String text1,String text2,int[][] dp){
        //base case
        if(i==0 || j==0){
            return 0;
        }
        //overlapping case
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        //rec
        if(text1.charAt(i-1) == text2.charAt(j-1)){
            return dp[i][j] = 1 + helper(i-1,j-1,text1,text2,dp);
        }

        return dp[i][j] = 0 + Math.max(helper(i-1,j,text1,text2,dp),helper(i,j-1,text1,text2,dp));
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