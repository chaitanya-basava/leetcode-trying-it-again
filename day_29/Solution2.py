class Solution(object):
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])
        dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        visited = [[False for i in range(n)] for j in range(m)]

        def check(i, j):
            return 0 <= i < m and 0 <= j < n and not visited[i][j] and grid[i][j] == 1

        def dfs(i, j):
            visited[i][j] = True

            area = 1
            for dir in dirs:
                x, y = i + dir[0], j + dir[1]
                if check(x, y):
                    area += dfs(x, y)

            return area

        ans = 0
        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == 1:
                    ans = max(ans, dfs(i, j))

        return ans
