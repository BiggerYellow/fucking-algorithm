class Solution:
    def numSquares(self, n:int) -> int:
        dp =[0]*(n+1)
        for i in range(0, n+1):
            dp[i]=i
            for j in range(1, int(n**0.5)+1):
                if i-j*j>=0:
                    dp[i] =min(dp[i], dp[i-j*j]+1)
        return dp[n]


if __name__ == '__main__':
    print(Solution().numSquares(13))