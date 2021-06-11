from typing import List


class Solution:
    def lastStoneWeightII(self, stones:List[int]) -> int:
        sum=0
        for v in stones:
            sum+=v
        cap = sum//2
        dp = [[0]*(cap+1) for i in range (len(stones)+1)]
        for i in range(1,len(stones)+1):
            for j in range(cap+1):
                if j>= stones[i-1]:
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j-stones[i-1]]+stones[i-1])
                else:
                    dp[i][j] = dp[i-1][j]

        return sum-dp[len(stones)][cap]*2

    def lastStoneWeightII1(self, stones:List[int]) -> int:
        sum=0
        for v in stones:
            sum+=v
        cap = sum//2
        dp = [0]*(cap+1)
        for num in stones:
            for j in range(cap, num-1,-1):
                dp[j] = max(dp[j],dp[j-num]+num)
        return sum-dp[cap]*2


if __name__ == '__main__':
    stones = [2,7,4,1,8,1]
    print(Solution().lastStoneWeightII1(stones))