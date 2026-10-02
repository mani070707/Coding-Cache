class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();

        vector<vector<int>> vis(n,vector<int> (m,0));
        vector<vector<int>> dist(n,vector<int> (m,0));
        queue<pair<pair<int,int>,int>> q;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    
                    q.push({{i,j},0});
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        
        int delrow[] = {-1,1,0,0};
        int delcol[] = {0,0,-1,1};
        while(!q.empty()){
            auto it = q.front();
            q.pop();
            int i = it.first.first;
            int j = it.first.second;
            int steps = it.second;
            dist[i][j] = steps;
            
            for(int k=0;k<4;k++){
                int nr = i + delrow[k];
                int nc = j + delcol[k];
                if(nr >= 0 && nr <n && nc >= 0 && nc < m && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.push({{nr,nc},steps+1});
                }
            }
        }

        return dist;
    }
};