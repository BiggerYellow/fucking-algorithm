from random import randrange
from typing import List


class Solution:
    def __init__(self, nums:List[int]):
        self.nums = nums

    def pick(self, target:int) -> int:
        ans = cnt = 0
        for i, num in enumerate(self.nums):
            if num == target:
                cnt += 1
                if randrange(cnt) == 0:
                    ans = i
        return ans



class Solution:

    def selectK(self, nums:List[int], k:int) -> List[int]:
        res = list()
        for i in range(0, k):
            res[i] = nums[i]
        count = k
        i = k
        while i < len(nums):
            ++count
            j = randrange(count)
            if j<k:
                res[j] = nums[i]
        return res