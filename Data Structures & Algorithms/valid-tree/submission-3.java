class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        if (edges.length != n - 1) return false;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int count=1;
        Queue<int[]> q= new ArrayDeque<>();
        boolean[] visited= new boolean[n];
        q.offer(new int[]{0, -1});
        visited[0]=true;
        while(!q.isEmpty()){
            int[] x=q.poll();
            int node=x[0];
            int parent=x[1];
            
            for(int j:adj.get(node)){
                if(!visited[j]){
                    visited[j]=true;
                    count++;
                    q.offer(new int[]{j, node});
                }else{
                    if(j!=parent)return false;
                }
            }
        }
        return count == n;


    }
}
