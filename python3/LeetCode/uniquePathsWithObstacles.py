from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        dp = [[0]*n for i in range(m)]
        for i in range(0, m):
            if obstacleGrid[i][0] == 1:
                break
            dp[i][0]=1

        for j in range(0, n):
            if obstacleGrid[0][j] == 1:
                break
            dp[0][j]=1

        for i in range (1,m):
            for j in range (1,n):
                if obstacleGrid[i][j] == 0:
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]

        return dp[m-1][n-1]


if __name__ == '__main__':
    obstacleGrid = [[0,1,0],[0,0,0],[0,0,0]]
    print(Solution().uniquePathsWithObstacles(obstacleGrid))