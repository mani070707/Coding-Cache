class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        int[] topo = new int[V];

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int i=0;
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            topo[i++] = node;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        if(cnt == V) return topo;
        return new int[]{};


    }
}