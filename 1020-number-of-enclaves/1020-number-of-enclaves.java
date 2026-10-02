class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        //Mutli-source bfs
        //1st we should mark vis T all those nodes which the vis from border
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean border = (i == 0 || j== 0 || i == n-1 || j== m-1);
                if(border && grid[i][j] == 1){
                    vis[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for(int d = 0; d<4; d++){
                int newR = r + dr[d];
                int newC = c + dc[d];

                if(newR >=0 && newC >=0 && newR <n && newC < m && grid[newR][newC] == 1 && !vis[newR][newC]){
                    vis[newR][newC] = true;
                    q.offer(new int[]{newR,newC});
                }
            }
        }
        int cnt = 0;

        //to find the land(1) which is not reachable from 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]) cnt++;
            }
        }

        return cnt;
    }
}