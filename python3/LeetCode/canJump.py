from typing import List


class Solution:
    def canJump(self, nums:List[int]) -> bool:
        end = 0
        for i in range(0, len(nums)):
            if i>end:
                return False

            end = max(end, i+nums[i])
        return True

if __name__ == '__main__':
    nums = {2,3,1,1,4}
    print(Solution().canJump(nums))