import sys

class Solution:
    def twoEggDrop(self, n : int) -> int:
        dp = [[sys.maxsize]*2 for i in range (n+1)]
        dp[0][0]=0
        for i in range(1, n+1):
            dp[i][0]=i
        for i in range(1,n+1):
            for k in range(1, i+1):
                dp[i][1] = min(dp[i][1], max(dp[k-1][0]+1, dp[i-k][1]+1))

        return dp[n][1]


if __name__ == '__main__':
    print(Solution().twoEggDrop(2))