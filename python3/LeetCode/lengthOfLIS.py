from typing import List


class Soultion:
    def lengthOfLIS(self, nums:List[int]) -> int:
        dp = [1]*(len(nums)+1)
        res=1
        for i in range (1, len(nums)):
            for j in range(i,-1,-1):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j]+1)
            res = max(res, dp[i])
        return res


    def lengthOfLIS1(self, nums:List[int]) -> int:
        tail = [0]*(len(nums)+1)
        res=0
        for num in (nums):
            i,j=0,res
            while i<j:
                mid = (i+j)//2
                if tail[mid] < num:
                    i=mid+1
                else:
                    j=mid
            tail[i] = num
            if res == j:
                res+=1
        return res



if __name__ == '__main__':
    nums = [10,9,2,5,3,7,101,18]
    print(Soultion().lengthOfLIS(nums))