class Solution {
    public void dfs(int[][] image, int sr, int sc, int color,int cur){
        int n = image.length;
        int m = image[0].length;
        

        if(sr < 0 || sc < 0 || sr >= n || sc >= m){
            return;
        }
        if(cur != image[sr][sc]) return;
        image[sr][sc] = color;
        dfs(image, sr+1,sc,color,cur);
        dfs(image, sr,sc-1,color,cur);
        dfs(image, sr-1,sc,color,cur);
        dfs(image, sr,sc+1,color,cur);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color) return image;

        dfs(image,sr,sc,color,image[sr][sc]);

        return image;
    }
}