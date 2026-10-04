class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int[] r:relations){
            adj.get(r[0]-1).add(r[1]-1);
            indegree[r[1]-1]++;
        }
        List<Integer> ls= new ArrayList<>();
        Queue<int[]> q= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(new int[] {i, 1});
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int[] x=q.poll();
            ls.add(x[0]);
            c=Math.max(c, x[1]);
            for(int j:adj.get(x[0])){
                indegree[j]--;
                if(indegree[j]==0){
                    q.offer(new int[] {j, x[1]+1});
                }
            }
        }
        if(ls.size()!=n)return -1;
        return c;
    }
}
