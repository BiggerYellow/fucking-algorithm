from typing import List


class Solution:
    def majorityElement(self, nums:List[int]) -> int:
        candidate = -1
        count = 0
        for num in nums:
            if count==0:
                candidate = num
            if num == candidate:
                count+=1
            else:
                count-=1

        count=0
        for num in nums:
            if num == candidate:
                count+=1
        if count*2 >= len(nums):
            return candidate
        else:
            return -1