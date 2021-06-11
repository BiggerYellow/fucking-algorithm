from typing import List


class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        left, right = max(weights), sum(weights)

        while left< right:
            mid = (left+right)//2

            days = 1
            temp = 0
            for weight in weights:
                temp+=weight
                if temp > mid:
                    days+=1
                    temp = weight

            if days > D:
                left = mid+1
            else:
                right = mid
        return left


if __name__ == '__main__':
    weights = [1,2,3,4,5,6,7,8,9,10]
    print(Solution().shipWithinDays(weights, 5))