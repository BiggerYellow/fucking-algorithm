from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums:List[int]) -> int:
        length = len(nums)
        if length == 1:
            return 0
        diff = nums[0]-nums[1]
        count=0
        res=0
        for i in range(2, length):
            if nums[i-1]-nums[i] == diff:
                count+=1
            else:
                diff = nums[i-1]-nums[i]
                count=0
            res+=count
        return res