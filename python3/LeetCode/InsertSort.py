from typing import List


class Solution:
    def insertSort(self, nums:List[int]):
        length = len(nums)
        for i in range(1, length):
            for j in range(i, 0,-1):
                if nums[j]<nums[j-1]:
                    self.swap(nums, j, j-1)

    def swap(self, nums:List[int], i,j:int):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp


if __name__ == '__main__':
    nums = [6,1,4,9,7,2]
    Solution().insertSort(nums)
    print(nums)