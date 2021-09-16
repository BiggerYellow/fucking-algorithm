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


    def quickSort1(self, nums:List[int], left:int, right:int):
        def swap(nums:List[int], i:int, j:int):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp

        def division(nums:List[int], left:int, right:int) -> int:
            i=left+1
            j=right
            base = nums[left]
            while True:
                while base >= nums[i]:
                    i+=1
                    if i == right:
                        break
                while base <= nums[j]:
                    j-=1
                    if j==left:
                        break
                if j<=i:
                    break
                swap(nums, i, j)

            swap(nums, left, j)
            return j

        if right<=left:
            return
        base = division(nums, left ,right)
        self.quickSort1(nums, left, base-1)
        self.quickSort1(nums, base+1, right)

if __name__ == '__main__':
    nums = [3,1,2,6,5]
    Solution().quickSort1(nums, 0 ,len(nums)-1)
    print(nums)