from typing import List


class Solution:
    def kthLargestValue(self, matrix:List[List[int]], k:int) -> int:
        row, col = len(matrix), len(matrix[0])
        res = list()
        dp = [[0]*(col+1) for _ in range(row+1)]

        for i in range(1,row+1):
            for j in range(1, col+1):
                dp[i][j] = dp[i-1][j] ^ dp[i][j-1] ^ dp[i-1][j-1] ^ matrix[i-1][j-1]
                res.append(dp[i][j])

        res.sort(reverse=True)
        return res[k-1]

        def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
            m, n = len(matrix), len(matrix[0])
            pre = [[0] * (n + 1) for _ in range(m + 1)]
            results = list()
            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1]
                    results.append(pre[i][j])

            results.sort(reverse=True)
            return results[k - 1]
