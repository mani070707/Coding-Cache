class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    ans++;
                }
                else if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        if(ans == 0){
            return 0;
        }
        int min = -1;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            min++;
            for(int i=0;i<size;i++){
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];

                for(int[] d : dir){
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if(nx <0 || ny <0 || nx >= n || ny >= m || vis[nx][ny] || grid[nx][ny] != 1){
                        continue;
                    }

                    vis[nx][ny] = true;
                    ans--;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        return ans == 0 ? min : -1;

    }
}