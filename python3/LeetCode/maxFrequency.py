from typing import List


class Solution:
    def maxFrequency(self, nums:List[int], k:int) -> int:
        nums.sort()
        res=1
        count=0
        left=0
        for right in range(1, len(nums)):
            count+=(nums[right]-nums[right-1])*(right-left)
            while count>k:
                count -= nums[right]-nums[left]
                left+=1
            res = max(res, right-left+1)
        return res