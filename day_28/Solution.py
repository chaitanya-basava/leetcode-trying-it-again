from collections import defaultdict, deque


class Solution(object):
    def __dfs(self, node, time):
        self.bob_path[node] = time
        if node == 0:
            return True

        for nei in reversed(self.adj[node]):
            if nei in self.bob_path:
                continue

            if self.__dfs(nei, time+1):
                return True

        self.bob_path.pop(node, None)
        return False

    def mostProfitablePath(self, edges, bob, amount):
        """
        :type edges: List[List[int]]
        :type bob: int
        :type amount: List[int]
        :rtype: int
        """
        self.bob_path = {}
        self.adj = defaultdict(lambda: [])
        for edge in edges:
            self.adj[edge[0]].append(edge[1])
            self.adj[edge[1]].append(edge[0])

        # print(self.adj)
        self.__dfs(bob, 0)
        # print(self.bob_path)

        # bfs for alice
        queue = deque()
        queue.append([0, 0, -1, amount[0]])

        ans = float("-inf")
        while(len(queue) != 0):
            node, time, parent, profit = queue.popleft()
            for nei in self.adj[node]:
                if nei == parent:
                    continue

                nei_time = time + 1
                nei_profit = profit
                if nei in self.bob_path:
                    if nei_time < self.bob_path[nei]:
                        nei_profit += amount[nei]
                    elif nei_time == self.bob_path[nei]:
                        nei_profit += amount[nei] // 2
                else:
                    nei_profit += amount[nei]

                queue.append([nei, nei_time, node, nei_profit])

                # indicates that nei is a leaf
                if len(self.adj[nei]) == 1:
                    ans = max(ans, nei_profit)

        return ans
