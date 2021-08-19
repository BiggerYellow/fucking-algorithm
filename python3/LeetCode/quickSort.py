from typing import List


class Solution:
    def quickSort(self, nums:List[int], left:int, right:int):
        def division(nums:List[int], left:int, right:int)->int:
            base = nums[left]
            while left<right:
                while left<right and nums[right]>=base:
                    right-=1
                nums[left]=nums[right]
                while left<right and nums[left]<=base:
                    left+=1
                nums[right]=nums[left]
            nums[left]=base
            return left
        if left<right:
            temp = division(nums, left ,right)
            self.quickSort(nums, left, temp-1)
            self.quickSort(nums, temp+1, right)

if __name__ == '__main__':
    nums = [3,1,2,6,5]
    Solution().quickSort(nums, 0 ,len(nums)-1)
    print(nums)