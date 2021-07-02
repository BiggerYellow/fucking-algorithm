from typing import List


class Solution:
    def findMaxForm(self, strs:List[str], m:int, n:int) -> int:
        dp = [[[0]*(n+1) for i in range(m+1)] for i in range(len(strs)+1)]
        for i in range(1, len(strs)+1):

            count0 = strs[i-1].count("0")
            count1 = strs[i-1].count("1")
            for j in range(m+1):
                for k in range(n+1):
                    dp[i][j][k]=dp[i-1][j][k]
                    if j>=count0 and k>=count1:
                        dp[i][j][k]= max(dp[i-1][j][k], dp[i-1][j-count0][k-count1]+1)

        return dp[len(strs)][m][n]

    def findMaxForm1(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0]*(n+1) for i in range(m+1)]
        for i in range(1, len(strs)+1):
            count0=strs[i-1].count("0")
            count1=strs[i-1].count("1")
            for j in range(m, count0-1,-1):
                for k in range(n, count1-1,-1):
                    dp[j][k] = max(dp[j][k], 1+dp[j-count0][k-count1])
        return dp[m][n]

if __name__ == '__main__':
    strs =  ["10", "0001", "111001", "1", "0"]
    m=5
    n=3
    print(Solution().findMaxForm1(strs, m,n))