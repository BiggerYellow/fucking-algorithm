from typing import List
class Solution:
    def removeElement(nums: List[int], val: int) -> int:
        if len(nums)==0:
            return 0
        i=0
        for x in nums:
            if(x != val):
                nums[i] = x
                i+=1
        return i

if __name__ == '__main__':
    nums = [1,2,3,4]
    print(Solution.removeElement(nums,3))