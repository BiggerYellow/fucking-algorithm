from typing import List


class Solution:
    #内部正序
    def bubbleSort(self, nums:List[int]):
        length = len(nums)
        for i in range(0, length-1):
            for j in range(0, length-i-1):
                if nums[j+1] < nums[j]:
                    temp = nums[j]
                    nums[j] = nums[j+1]
                    nums[j+1] = temp

    #内部正序
    def bubbleSort1(self, nums:List[int]):
        length = len(nums)
        for i in range(0, length):
            for j in (length-1, i, -1):
                if nums[j-1]>nums[j]:
                    temp = nums[j]
                    nums[j] = nums[j-1]
                    nums[j-1] = temp



if __name__ == '__main__':
    nums = [3,1,2,7,5]
    Solution().bubbleSort1(nums)
    print(nums)