from typing import List


class Solution:
    def rob(self, nums:List[int]) -> int:
        n = len(nums)
        if n==1:
            return nums[0]
        dp = [0]*n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, n):
            dp[i] = max(dp[i-2]+nums[i], dp[i-1])

        return dp[n-1]


    def rob1(self, nums:List[int]) -> int:
        n=len(nums)
        if n==1:
            return nums[0]
        dp = [[0]*2 for i in range(n)]
        dp[0][0] = 0
        dp[0][1] = nums[0]
        dp[1][0] = nums[1]
        dp[1][1] = nums[0]

        for i in range(2,n):
            dp[i][0] = max(dp[i-2][0]+nums[0], dp[i-1][0])
            if i==n-1:
                dp[i][1] = dp[i-1][0]
            else:
                dp[i][1] = max(dp[i-2][1]+nums[i], dp[i-1][1])

        return max(dp[n-1][0], dp[n-1][1])
