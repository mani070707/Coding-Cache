class Solution {
    public int swimInWater(int[][] grid) {
        // at T = t water level = t
        // elevation <= t
        // (0,0) -> (n-1,n-1)
        int m = grid.length;
        int n =grid[0].length;
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int low = grid[0][0];
        int high = 0;

        for(int[] row : grid){
            for(int val : row){
                high = Math.max(high,val);
            }
        }

        while(low < high){
            int mid = low + (high - low)/2;
            if(possible(grid,mid,m,n,dir)){
                high = mid;
            }
            else{
                low = mid + 1;
            }

        }
        return low;
        
    }

    private boolean possible(int[][] grid, int mid, int m ,int n ,int[][] dir){
        if(grid[0][0] > mid){
            return false;
        }
        boolean[][] vis = new boolean[n][m];
        return dfs(grid,0,0,mid,vis,m,n,dir);
    }

    private boolean dfs(int[][] grid, int i, int j, int mid ,boolean[][] vis,int m, int n , int[][] dir){
        if(i == m-1 && j == n-1) return true;
        vis[i][j] = true;

        for(int[] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];
            if(nr >=0 && nc >= 0 && nr < m && nc < n && !vis[nr][nc]){
                if(grid[nr][nc] <= mid){
                    if(dfs(grid,nr,nc,mid,vis,m,n,dir)){
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
}