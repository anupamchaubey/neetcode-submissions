class Solution {
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    int m;
    int n;
    Integer[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        dp=new Integer[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max, rec(matrix, i, j));
            }
        }
        return max+1;
    }
    int rec(int[][] matrix, int r, int c){
        if(dp[r][c]!=null)return dp[r][c];
        int max=0;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && matrix[nr][nc]>matrix[r][c]){
                max=Math.max(max, 1+rec(matrix, nr, nc));
            }
        }
        return dp[r][c]=max;
    }
}
