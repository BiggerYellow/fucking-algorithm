from typing import List


class Solution:
    def selectSort(self, nums:List[int]):
        length = len(nums)
        for i in range(0, length):
            min = i
            for j in range(i+1, length):
                if nums[min]>nums[j]:
                    min = j
            self.swap(nums, min, i)

    def swap(self, nums:List[int], i:int, j:int):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp






if __name__ == '__main__':
    nums = [5,6,1,3,8]
    Solution().selectSort(nums)
    print(nums)