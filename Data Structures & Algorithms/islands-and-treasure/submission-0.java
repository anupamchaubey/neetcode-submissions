class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    int m;
    int n;
    public void islandsAndTreasure(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited= new boolean[m][n];
        Queue<int[]> q= new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    visited[i][j]=true;
                    q.offer(new int[] {i, j, 0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            int d=curr[2];
            if(grid[row][col]==Integer.MAX_VALUE)grid[row][col]=d;
            for(int i=0;i<4;i++){
                int r=row+dr[i];
                int c=col+dc[i];
                if(r>=0 && c>=0 && r<m && c<n && grid[r][c]!=-1 && !visited[r][c]){
                    visited[r][c]=true;
                    q.offer(new int[]{r, c, d+1});
                }
            }
        }
    }
}
