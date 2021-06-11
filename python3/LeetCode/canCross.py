from typing import List

class Solution:
    def canCross(self, stones: List[int]) ->bool:
        dp = [[] for i in range(len(stones))]
        dp[0].append(True)
        for i in range(1, len(stones)):
            if stones[i] - stones[i-1] > i:
                return False

        for i in range(1, len(stones)):
            for j in range(i-1, 0, -1):
                k = stones[i] - stones[j]
                if k > j+1:
                    break
                dp[i][k] =  dp[j][k-1]or dp[j][k] or dp[j][k+1]

                if i==len(stones)-1 and dp[i][k]:
                    return True
        return False


if __name__ == '__main__':
    stones = [0,1,3,5,6,8,12,17]
    print(Solution().canCross(stones))