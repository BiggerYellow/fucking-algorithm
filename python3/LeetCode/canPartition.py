from typing import List


class Solution:
    def canPartition(self, nums:List[int]) -> bool:
        sum=0
        for num in nums:
            sum+=num
        if sum%2==1:
            return False
        cap=sum//2

        dp = [[False]*(cap+1) for i in nums]
        if nums[0] <= cap:
            dp[0][nums[0]]=True
        for i in range(1, len(nums)):
            for j in range(0, cap+1):
                dp[i][j]=dp[i-1][j]
                if nums[i] < j:
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]]
                if nums[i] == j:
                    dp[i][j] = True
        return dp[len(nums)-1][cap]


    def canPartition1(self, nums:List[int]) -> bool:
        sum=0
        for num in nums:
            sum+=num
        if sum%2==1:
            return False
        cap = sum//2
        dp = [False]*(cap+1)
        if nums[0] <=cap:
            dp[nums[0]]=True
        for i in range(1, len(nums)):
            for j in range(cap, nums[i]-1, -1):
                if nums[i]<j:
                    dp[j]=dp[j-1]|dp[j-nums[i]]
                if nums[i]==j:
                    dp[j]=True

        return dp[cap]


if __name__ == '__main__':
    nums = [1,5,11,5]
    print(Solution().canPartition1(nums))