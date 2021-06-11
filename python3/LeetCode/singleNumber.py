import collections
from typing import List

class Solution:
    def singleNumber(self, nums:List[int]) ->int:
        frep = collections.Counter(nums)
        res = [num for num, occ in frep.items() if occ == 1][0]
        return res

    def singleNumber1(self, nums:List[int]) ->int:
        res = 0
        for i in range(0,32):
            total = sum((num >> i)&1 for num in nums)
            if total % 3:
                if i==31:
                    res -=(1<<i)
                else:
                    res |=(1<<i)
        return res


if __name__ == '__main__':
    nums = [1,1,1,3]
    print(Solution().singleNumber1(nums))

