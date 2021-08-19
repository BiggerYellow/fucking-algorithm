from typing import List


class Solution:
    def isCovered(self, ranges:List[List[int]], left:int, right:int) -> bool:
        arr = [0]*52
        for i in range(0,len(ranges)):
            arr[ranges[i][0]]+=1
            arr[ranges[i][1]+1]-=1

        sum = [0]*52
        sum[0] = arr[0]
        for i in range(1, 52):
            sum[i] = sum[i-1]+arr[i]

        for i in range(left, right+1):
            if sum[i] <= 0:
                return False
        return True