from typing import List


class Solution:
    def radixSort(self, nums:List[int], d:int):
        k=0
        n=1
        m=1
        length = len(nums)
        temp = [[0]*length for i in range (10)]
        order = [0]*10

        while m<=d:
            for i in range(0,length):
                lsd  = (nums[i]//n)%10
                temp[lsd][order[lsd]] = nums[i]
                order[lsd]+=1

            for i in range(0,10):
                if order[i] != 0:
                    for j in range(0, order[i]):
                        nums[k] = temp[i][j]
                        k+=1
                order[i]=0
            k=0
            m+=1
            n*=10


if __name__ == '__main__':
    nums = [123,54,12,76,34,6,12]
    Solution().radixSort(nums, 3)
    print(nums)