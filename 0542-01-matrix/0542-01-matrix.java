class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        //bfs ie level order to find the nearest 0
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }


        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,1,-1};

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            int dis = node[2];
            dist[r][c] = dis;

            for(int d=0; d<4; d++){
                int newR = r + dr[d];
                int newC = c + dc[d];

               if(newR >= 0 && newC >= 0 && newR < n && newC < m && !vis[newR][newC]){
                    vis[newR][newC] = true;
                    q.offer(new int[]{newR,newC,dis+1});
               }
            }
        }
        return dist;

    }
}