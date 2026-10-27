import java.util.Arrays;

class Solution {

    private boolean dfs(int row, int col, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check bounds before accessing the grid
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols) {
            return false;
        }

        // Mark current cell as part of the path
        grid[row][col] = '.';

        // Destination reached
        if (row == rows - 1 && col == cols - 1) {
            return true;
        }

        // Try moving right
        if (dfs(row, col + 1, grid)) {
            return true;
        }

        // Try moving down
        if (dfs(row + 1, col, grid)) {
            return true;
        }

        // This cell cannot lead to the destination
        grid[row][col] = '#';
        return false;
    }

    public String[] createGrid(int m, int n) {
        if (m <= 0 || n <= 0) {
            return new String[0];
        }

        char[][] grid = new char[m][n];

        for (char[] row : grid) {
            Arrays.fill(row, '#');
        }

        dfs(0, 0, grid);

        String[] answer = new String[m];

        for (int row = 0; row < m; row++) {
            answer[row] = new String(grid[row]);
        }

        return answer;
    }
}