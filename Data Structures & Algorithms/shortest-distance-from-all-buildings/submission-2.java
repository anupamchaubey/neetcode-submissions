class Solution {
    public int shortestDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] dr={-1, 1, 0, 0};
        int[] dc={0, 0, -1, 1};
        int[][] val= new int[m][n];
        int[][] count= new int[m][n];

        for(int[] v: val){
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        int buildings=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)buildings++;
            }
        }
        Queue<int[]> q= new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    boolean[][] visited= new boolean[m][n];
                    visited[i][j]=true;
                    q.offer(new int[]{i, j, 0});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int row=arr[0];
            int col=arr[1];
            int d=arr[2];
            if(grid[row][col]==0 ){
                if(val[row][col]==Integer.MAX_VALUE ){
                    val[row][col]=d;
                }else{
                    val[row][col]+=d;
                }
                count[row][col]+=1;
            }
            for(int k=0;k<4;k++){
                int r=row+dr[k];
                int c=col+dc[k];
                if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==0 && !visited[r][c]){
                    visited[r][c]=true;
                    q.offer(new int[]{r, c, d+1});
                }
            }
        }
                }
            }
        }
        
        
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(count[i][j]==buildings){
                    min=Math.min(min, val[i][j]);
                }
                
            }
        }
        return min==Integer.MAX_VALUE? -1: min;
    }
}
