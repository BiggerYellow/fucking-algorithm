from typing import List


class Solution:
    def heapSort(self, nums:List[int]):
        length = len(nums)
        for i in range(length//2, -1, -1):
            self.sink(nums, i, length)

        while length>1:
            length-=1
            self.swap(nums, 0, length)
            self.sink(nums, 0, length)



    def sink(self, nums:List[int], k:int, len:int):
        while 2*k+1<len:
            j = 2*k+1
            while j+1<len and nums[j+1]>nums[j]:
                j+=1
            if nums[k]> nums[j]:
                break
            self.swap(nums, j, k)
            k=j

    def swap(self, nums: List[int], i: int, j: int):
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp

if __name__ == '__main__':
    nums = [5,3,6,1,8]
    Solution().heapSort(nums)
    print(nums)