class Solution {
    public boolean dfs(int idx,int col,int[] color,int[][] graph){
        color[idx] = col;  // addedd the idx in 0 team or A team

        //go in neigher and check
        for(int ng : graph[idx]){
            if(color[ng] == -1){
                if(!dfs(ng,1 - col,color,graph)){
                    return false;
                }
            }
            else if(color[ng] == col){
                return false;
            }
            //if else is set we dont have to do anything
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color,-1); //unvisited

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(!dfs(i,0,color,graph)){
                    return false;
                }
            }
        }
        return true;
    }
}