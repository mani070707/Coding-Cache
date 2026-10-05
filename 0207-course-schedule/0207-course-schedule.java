class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;


        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;

            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
        }

        return cnt == V;
    }
}