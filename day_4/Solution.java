class Solution {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static class Pair<T, U> {
        T first;
        U second;
        Pair(T f, U s) {
            this.first = f;
            this.second = s;
        }
    }

    private boolean valid(int r, int c, int rows, int cols) {
        return 0 <= r && r < rows && 0 <= c && c < cols;
    }

    private int bfs(int[][] grid, int r, int c, int rows, int cols, int component) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(r, c));
        grid[r][c] = component;

        int area = 0;
        while(!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            r = p.first;
            c = p.second;
            area++;
            for(int[] d: dirs) {
                if(valid(r+d[0], c+d[1], rows, cols) && grid[r+d[0]][c+d[1]] == 1) {
                    q.add(new Pair(r+d[0], c+d[1]));
                    grid[r+d[0]][c+d[1]] = component;
                }
            }
        }

        return area;
    }

    public int largestIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Map<Integer, Integer> areas = new HashMap<>();

        int components = 2;
        int ans = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    int area = bfs(grid, i, j, rows, cols, components);
                    areas.put(components++, area);
                    ans = Math.max(ans, area);
                }
                // System.out.print(grid[i][j] + " ");
            }
            // System.out.println();
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != 0) continue;
                Set<Integer> seen = new HashSet<>();
                int new_area = 1;
                for(int[] d: dirs) {
                    int r = i + d[0], c = j + d[1];
                    if(valid(r, c, rows, cols) && grid[r][c] != 0) {
                        if(!seen.contains(grid[r][c])) {
                            new_area += areas.get(grid[r][c]);
                            seen.add(grid[r][c]);
                        }
                    }
                }
                ans = Math.max(ans, new_area);
            }
        }

        return ans;
    }
}