class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    ans++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        if(ans == 0){
            return 0;
        }
        

        int time = 0;
        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,1,-1};

        while(!q.isEmpty() && ans> 0){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
            
                for(int d = 0; d < 4 ;d++){
                    int newR = r + dr[d];
                    int newC = c + dc[d];

                    if(newR >= 0 &&  newC >= 0 && newR<n && newC < m && grid[newR][newC] == 1 && !vis[newR][newC]){
                        q.offer(new int[]{newR,newC});
                        vis[newR][newC] = true;
                        ans--;
                    }
                }
            }
            time++;
        }

        return ans == 0 ? time : -1;
    }
}