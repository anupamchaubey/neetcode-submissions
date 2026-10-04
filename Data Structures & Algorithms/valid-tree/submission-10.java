class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int[] parent=new int[n];
        

        visited[0] = true;
            parent[0]=-1;
            q.offer(0);
            while (!q.isEmpty()) {
                int x = q.poll();
                for (int v : adj.get(x)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                        parent[v]=x;
                    } else if (v != parent[x])
                        return false;
                }
            }
        for(boolean v:visited)if(!v)return false;
        return true;
    }
}
