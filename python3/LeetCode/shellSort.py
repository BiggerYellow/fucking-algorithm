from typing import List


class Solution:
    def shellSort(self, nums:List[int]):
        length = len(nums)
        factor = 2
        h=1
        while h<length//factor:
            h=h*factor+1

        while h>=1:
            for i in range(h, length):
                for j in range(i, h-1,-2):
                    if nums[j] < nums[j-h]:
                        self.swap3(nums, j, j-h)
            h//=factor


    def swap3(self,nums:List[int], i,j:int):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp


if __name__ == '__main__':
    nums = [6,1,3,8,4,9]
    Solution().shellSort(nums)
    print(nums)