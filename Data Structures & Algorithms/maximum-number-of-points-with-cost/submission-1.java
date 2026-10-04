class Solution {
    Long[][] dp;
    public long maxPoints(int[][] points) {
        dp=new Long[points.length][points[0].length];
        long max=0;
        for(int i=0;i<points[0].length;i++){
            max=Math.max(max, points[0][i]+rec(points, 1, i));
        }
        return max;
    }
    long rec(int[][] points, int i, int prev){
        if(i>=points.length)return 0;
        if(dp[i][prev]!=null)return dp[i][prev];
        long max=0;
        for(int j=0;j<points[i].length;j++){
            max=Math.max(max, points[i][j]+rec(points, i+1, j)-Math.abs(prev-j));
        }
        return dp[i][prev]=max;
    }
}