from typing import List


class Solution:
    def totalHammingDistance(self, nums:List[int]) -> int:
        res = 0
        n = len(nums)
        for i in range(0,31):
            temp =0
            for num in nums:
                temp+=(num>>i)&1
            res+= temp*(n-temp)
        return res

if __name__ == '__main__':
    nums = [4,14,2]
    print(Solution().totalHammingDistance(nums))