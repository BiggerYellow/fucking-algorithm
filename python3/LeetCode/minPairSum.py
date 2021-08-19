from typing import List


class Solution:
    def minPairSum(self, nums:List[int]) -> int:
        nums.sort()
        length = len(nums)
        res = 0
        for i in range (0, length//2):
            res = max(res, nums[i]+nums[length-1-i])
        return res
