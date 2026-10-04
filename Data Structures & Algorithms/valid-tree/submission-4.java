class Solution {
    int[] parent;
    int[] rank;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;


    }
    int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
    boolean union(int x, int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return false;
        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(rank[py]>rank[px]){
            parent[px]=py;
        }else{
            parent[py]=px;
            rank[px]++;
        }
        return true;
    }
    boolean connected(int x, int y){
        return find(x)==find(y);
    }
}
