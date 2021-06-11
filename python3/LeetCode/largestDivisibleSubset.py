from typing import List


class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()
        dp = [1] * len(nums)
        prev = [-1] * len(nums)
        max = 1
        maxIndex = 0
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[i] % nums[j] == 0 and dp[i] < dp[j]+1:
                    dp[i] = dp[j]+1
                    prev[i] = j

            if dp[i] > max:
                max = dp[i]
                maxIndex = i

        res = []
        while maxIndex!=-1:
            res.append(nums[maxIndex])
            maxIndex = prev[maxIndex]

        return res


if __name__ == '__main__':
    # nums = [2,3,8,9,27]
    nums = [3,4,16,8]
    print(Solution().largestDivisibleSubset(nums))