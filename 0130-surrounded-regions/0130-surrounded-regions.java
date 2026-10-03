import java.util.*;

class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];

        // Multi-source BFS: push all border 'O' cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean border = (i == 0 || j == 0 || i == n - 1 || j == m - 1);
                if (border && board[i][j] == 'O') {
                    vis[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for (int d = 0; d < 4; d++) {
                int newR = r + dr[d];
                int newC = c + dc[d];

                if (newR < 0 || newC < 0 || newR >= n || newC >= m
                        || board[newR][newC] == 'X' || vis[newR][newC]) {
                    continue;
                }

                vis[newR][newC] = true;
                q.offer(new int[]{newR, newC});
            }
        }

        // Any 'O' not connected to the border is surrounded: flip it
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}