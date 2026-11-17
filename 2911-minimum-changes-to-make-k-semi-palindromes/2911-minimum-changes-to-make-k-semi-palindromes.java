
import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

    

        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int len = j - i + 1;
                int best = Integer.MAX_VALUE;

                // Try all valid divisors of substring length
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Divide substring into d groups
                    for (int r = 0; r < d; r++) {

                        int left = i + r;

                        int right = i + r
                                + ((len - 1 - r) / d) * d;

                        // Make every group a palindrome
                        while (left < right) {

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    best = Math.min(best, changes);
                }

                cost[i][j] = best;
            }
        }

        // --------------------------------
        // STEP 2: Dynamic Programming
        // --------------------------------

        // dp[p][i] = minimum cost to divide
        // first i characters into exactly p parts

        int INF = 1_000_000_000;

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Base case
        dp[0][0] = 0;

        // p = number of partitions
        for (int p = 1; p <= k; p++) {

            // i = number of characters considered
            for (int i = 2 * p; i <= n; i++) {

                // j = starting index of last substring
                for (int j = 2 * (p - 1); j <= i - 2; j++) {

                    if (dp[p - 1][j] == INF) {
                        continue;
                    }

                    // Previous partitions + last substring cost
                    dp[p][i] = Math.min(
                        dp[p][i],
                        dp[p - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }

        // Final answer
        return dp[k][n];
    }
}
