from typing import List


count=0
class Solution:
    def findTargetSumWays(self, nums:List[int], target:int) ->int:
        global count
        self.dfs(nums, target, 0,0)
        return count


    def dfs(self, nums:List[int], target:int, index:int, sum:int):
        if index == len(nums):
            if sum == target:
                global count
                count+=1
        else:
            self.dfs(nums, target, index+1,sum+nums[index])
            self.dfs(nums, target, index+1,sum-nums[index])


    def findTargetSumWays1(self, nums:List[int], target:int) ->int:
        sum = 0
        for v in nums:
            sum+=v
        diff = sum - target
        if diff<0 or diff%2!=0:
            return 0
        mins = diff//2
        dp = [[0]*(mins+1) for i in range(len(nums)+1)]
        dp[0][0] = 1
        for i in range(1, len(nums)+1):
            num = nums[i-1]
            for j in range(mins+1):
                dp[i][j] = dp[i-1][j]
                if j>= num:
                    dp[i][j] += dp[i-1][j-num]

        return dp[len(nums)][mins]

    def findTargetSumWays2(self, nums:List[int], target:int) ->int:
        sum =0
        for v in nums:
            sum+=v
        diff = sum -target
        if diff<0 or diff%2!=0:
            return 0
        mins = diff//2
        dp = [0]*(mins+1)
        dp[0]=1
        for v in nums:
            for j in range(mins,v-1,-1):
                dp[j] += dp[j-v]
        return dp[mins]

if __name__ == '__main__':
    # nums=[7,9,3,8,0,2,4,8,3,9]
    nums=[1,1,1,1,1]
    print(Solution().findTargetSumWays2(nums, 3))