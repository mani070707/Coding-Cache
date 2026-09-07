class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            adj.get(p[0]).add(p[1]);
        }

        int[] indegree = new int[V];

        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int i=0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        if(i != V){
            return false;
        }
        return true;

    }
}