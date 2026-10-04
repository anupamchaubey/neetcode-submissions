class Solution {
    int[] dr={-1,-2,-2,-1,1,2,2,1};
    int[] dc={-2,-1,1,2,-2,-1,1,2};
    public int minKnightMoves(int x, int y) {
        
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][] visited=new boolean[607][607];
        int OFFSET = 302;
        q.offer(new int[]{OFFSET, OFFSET,0});
        visited[OFFSET][OFFSET]=true;
        x += OFFSET;
        y += OFFSET;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int row=arr[0];
            int col=arr[1];
            int d=arr[2];
            if(row==x && col==y)return d;
            for(int i=0;i<8;i++){
                int r=row+dr[i];
                int c=col+dc[i];
                if(r>=0 && c>=0 && r<607 && c<607 && !visited[r][c]){
                    visited[r][c]=true;
                    q.offer(new int[]{r, c, d+1});
                }
            }
        }
        return -1;
    }
}
