from typing import List


class Solution:
    def hIndex(self, citations:List[int]) -> int:
        length = len(citations)
        res=0
        for i in range (0, length):
            if(citations[i] >= length-i):
                return length-i

        return res


    def hIndex(self, citations:List[int]) -> int:
        length = len(citations)
        left=0
        right = length-1
        while left<=right:
            mid = left + (right-left)//2
            if citations[mid] >= length-mid:
                right = mid-1
            else:
                left = mid+1
        return length-left