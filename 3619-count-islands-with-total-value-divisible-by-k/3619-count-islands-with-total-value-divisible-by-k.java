class Solution {

    private long sumOfIsland(
        int row,
        int col,
        int[][] grid,
        boolean[][] visited
    ) {
        int rows = grid.length;
        int cols = grid[0].length;

        visited[row][col] = true;
        long sum = grid[row][col];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int direction = 0; direction < 4; direction++) {
            int newRow = row + dr[direction];
            int newCol = col + dc[direction];

            if (
                newRow >= 0 &&
                newRow < rows &&
                newCol >= 0 &&
                newCol < cols &&
                grid[newRow][newCol] > 0 &&
                !visited[newRow][newCol]
            ) {
                sum += sumOfIsland(newRow, newCol, grid, visited);
            }
        }

        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] > 0 && !visited[row][col]) {
                    long islandSum =
                        sumOfIsland(row, col, grid, visited);

                    if (islandSum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}