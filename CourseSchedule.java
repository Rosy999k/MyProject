class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        // Building the graph
        for(int[] courses : prerequisites) {
            int to = courses[0];
            int from = courses[1];
            var list = map.getOrDefault(from, new ArrayList<>());
            list.add(to);
            map.put(from, list);
            indegree[to]++;
        }

        // Implementation of Kahn's Alg
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            count++;
            if(map.containsKey(node)) {
                for(int nei : map.get(node)) {
                    indegree[nei]--;
                    if(indegree[nei] == 0) {
                        q.add(nei);
                    }
                }
            }
        }
        return count == numCourses;
    }
}