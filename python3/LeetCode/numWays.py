class Solution:
    def numWays(self, steps:int, arrLen:int) -> int:
        maxCol = min(steps//2+1, arrLen-1)
        dp = [0] * (maxCol+1)
        dp[0] = 1
        for i in range(1, steps+1):
            temp = [0]*(maxCol+1)
            for j in range(0, maxCol+1):
                if j == 0:
                    temp[j] = (dp[j] + dp[j+1])%1000000007
                elif j == maxCol:
                    temp[j] = (dp[j] + dp[j-1])%1000000007
                else:
                    temp[j] = (dp[j] + dp[j-1] + dp[j+1])%1000000007
            dp = temp
        return dp[0]



if __name__ == '__main__':
    print(Solution().numWays(3,2))