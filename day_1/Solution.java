import java.util.*;

class Solution {
    private int dr[] = { -1, 0, 1, 0 };
    private int dc[] = { 0, 1, 0, -1 };

    private static class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int bfs(int r, int c, int[][] grid, boolean[][] visited, int rows, int columns) {
        if(visited[r][c] || grid[r][c] == 0) return 0;

        Queue<Pair> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new Pair(r, c));

        int numFishes = 0;

        while(!q.isEmpty()) {
            Pair curr = q.remove();
            numFishes += grid[curr.first][curr.second];
            for(int i = 0; i < 4; i++) {
                int row = curr.first + dr[i];
                int col = curr.second + dc[i];

                if(0 <= row && row < rows && 0 <= col && col < columns
                        && !visited[row][col] && grid[row][col] > 0) {
                    q.add(new Pair(row, col));
                    visited[row][col] = true;
                }
            }
        }

        return numFishes;
    }

    public int findMaxFish(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];

        int ans = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == 0 || visited[i][j])
                    continue;

                ans = Math.max(ans, bfs(i, j, grid, visited, rows, columns));
            }
        }

        return ans;
    }
}