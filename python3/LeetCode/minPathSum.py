from typing import List


class Soluution:
    def minPathSum(self, grid:List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = [[0]*n for i in m]
        dp[0][0] = grid[0][0]

        for i in range(1,n):
            dp[0][i] = dp[0][i-1]+grid[0][i]
        for j in range(1,m):
            dp[j][0]=dp[j-1][0]+grid[j][0]

        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = grid[i][j] + min(dp[i-1][j-1], dp[i][j-1])
        return dp[m-1][n-1]