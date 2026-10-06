class Solution {
    public boolean dfs(int node, int[] vis,int[] pathVis,int[] safe,int[][] graph){
        vis[node] = 1;

        for(int it : graph[node]){
            if(vis[it] == 0){
                if(!dfs(it,vis,pathVis,safe,graph)){
                    return false;
                }
            }
            //we found a cycle
            else if(pathVis[it] == 1){
                return false;
            }
            else if(safe[it] == 0){
                return false;
            }
        }

        pathVis[node] = 0;
        safe[node] = 1;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        List<Integer> ans = new ArrayList<>();

        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] safe = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(i,vis,pathVis,safe,graph);
            }
        }

        for(int i=0;i<n;i++){
            if(safe[i] == 1){
                ans.add(i);
            }
        }

        return ans;


    }
}