class Solution {
    
    Integer[][] dp;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        this.m=m;
        this.n=n;
        dp=new Integer[m][n];
        return rec(0, 0);
    }
    int rec(int r, int c){
        if(r==m-1 && c==n-1)return 1;
        if(r==m || c==n)return 0;
        if(dp[r][c]!=null)return dp[r][c];

        int cnt=0;
        cnt+=rec(r+1, c);
        cnt+=rec(r, c+1);
        
        return dp[r][c]= cnt;
    }
}
