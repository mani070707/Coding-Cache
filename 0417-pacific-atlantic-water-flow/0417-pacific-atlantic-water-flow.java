class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // Start DFS from all Pacific-adjacent cells (top row + left column)
        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, pacific, n, m);       // left column
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, heights, pacific, n, m);       // top row
        }

        // Start DFS from all Atlantic-adjacent cells (bottom row + right column)
        for (int i = 0; i < n; i++) {
            dfs(i, m-1, heights, atlantic, n, m);    // right column
        }
        for (int j = 0; j < m; j++) {
            dfs(n-1, j, heights, atlantic, n, m);    // bottom row
        }

        // Collect cells reachable by both oceans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] visited, int n, int m) {
        visited[row][col] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int d = 0; d < 4; d++) {
            int newRow = row + dr[d];
            int newCol = col + dc[d];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
                && !visited[newRow][newCol] 
                && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, heights, visited, n, m);
            }
        }
    }
}