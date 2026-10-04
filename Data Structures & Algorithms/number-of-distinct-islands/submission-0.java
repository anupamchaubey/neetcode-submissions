class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    int m, n;

    public int numDistinctIslands(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Set<List<String>> hs = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j] && grid[i][j] == 1) {

                    List<String> ls = new ArrayList<>();

                    dfs(grid, i, j, i, j, visited, ls);

                    hs.add(ls);
                }
            }
        }

        return hs.size();
    }

    void dfs(int[][] grid, int i, int j,
             int sr, int sc,
             boolean[][] visited,
             List<String> ls) {

        visited[i][j] = true;

        ls.add((i - sr) + "," + (j - sc));

        for (int k = 0; k < 4; k++) {

            int r = i + dr[k];
            int c = j + dc[k];

            if (r >= 0 && c >= 0 && r < m && c < n
                && !visited[r][c]
                && grid[r][c] == 1) {

                dfs(grid, r, c, sr, sc, visited, ls);
            }
        }
    }
}
