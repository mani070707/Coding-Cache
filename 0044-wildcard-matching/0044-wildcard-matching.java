class Solution {
    public boolean helper(int i, int j, String s, String p, Boolean[][] dp) {
        if (i == 0 && j == 0) return true;
        if (j == 0) return false; // pattern exhausted, string still remains

        if (i == 0) {
            // string exhausted — remaining pattern must be all '*'
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k-1) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];

        boolean result;
        if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
            result = helper(i - 1, j - 1, s, p, dp);
        } else if (p.charAt(j-1) == '*') {
            result = helper(i - 1, j, s, p, dp) || helper(i, j - 1, s, p, dp);
        } else {
            result = false;
        }
        return dp[i][j] = result;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
        return helper(n, m, s, p, dp);
    }
}