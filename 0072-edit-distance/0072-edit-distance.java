class Solution {
    int[][] dp;

    public int helper(int i, int j, String word1, String word2){
        if(i == 0) return j ; // word1 exhausted -> insert remaining j+1 chars
        if(j == 0) return i ; // word2 exhausted -> delete remaining i+1 chars

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(word1.charAt(i-1) == word2.charAt(j-1)) {
            return dp[i][j] = helper(i-1, j-1, word1, word2); // skip, no cost
        }

        int delete = helper(i-1, j, word1, word2);
        int insert = helper(i, j-1, word1, word2);
        int replace = helper(i-1, j-1, word1, word2);

        return dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(n, m, word1, word2);
    }
}