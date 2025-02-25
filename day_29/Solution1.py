class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n = len(temperatures)
        stack = [(temperatures[-1], n-1)]
        next_greatest = [-1]

        for i in range(n-2, -1, -1):
            ele = temperatures[i]

            while len(stack) != 0 and stack[-1][0] <= ele:
                stack.pop()

            if len(stack) == 0:
                next_greatest.append(-1)
            else:
                next_greatest.append(stack[-1][1])

            stack.append([ele, i])

        ans = []
        for i in range(n):
            ele = next_greatest[n-i-1]
            if ele == -1:
                ans.append(0)
            else:
                ans.append(next_greatest[n-i-1] - i)

        return ans
