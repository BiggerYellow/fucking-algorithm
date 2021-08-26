from typing import List


class Solution:
    def mergeSort(self, nums:List[int]):
        temp = [0]*len(nums)
        def sort(nums:List[int], lo:int, hi:int):
            if hi<=lo:
                return
            mid = lo + (hi-lo)//2
            sort(nums, lo, mid)
            sort(nums, mid+1, hi)
            merge(nums, lo, mid, hi)

        def merge(nums:List[int], lo:int, mid:int, hi:int):
            i,j = lo, mid+1
            for k in range(lo, hi+1):
                temp[k] = nums[k]

            for k in range(lo, hi+1):
                if i>mid :
                    nums[k] = temp[j]
                    j+=1
                elif j>hi:
                    nums[k] = temp[i]
                    i+=1
                elif temp[j]<temp[i]:
                    nums[k] = temp[j]
                    j+=1
                else:
                    nums[k] = temp[i]
                    i+=1
        sort(nums, 0, len(nums)-1)


if __name__ == '__main__':
    nums = [7,1,4,6,9,2]
    Solution().mergeSort(nums)
    print(nums)