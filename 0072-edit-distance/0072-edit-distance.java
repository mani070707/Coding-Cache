class Solution {
    public int helper(int i,int j,String word1, String word2,int[][] dp){
        //base case
        if(i==0 ) return j;
        if(j==0) return i;
        //overlapping case
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        //rec
        if(word1.charAt(i-1) == word2.charAt(j-1)){
            return dp[i][j] = 0 + helper(i-1,j-1,word1,word2,dp);
        }
        int insert = helper(i,j-1,word1,word2,dp);
        int delete = helper(i-1,j,word1,word2,dp);
        int replace = helper(i-1,j-1,word1,word2,dp);

        return dp[i][j] = 1 + Math.min(delete,Math.min(insert,replace));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int[] row : dp){
            Arrays.fill(row,0);
        }

        // return helper(n,m,word1,word2,dp);

        //base

        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else{
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = 1 + Math.min(delete,Math.min(insert,replace));
                }
            }
        }
        return dp[n][m];
    }
}