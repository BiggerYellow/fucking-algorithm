from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        left = newInterval[0]
        right = newInterval[1]
        place = False

        res = [[0]*2 for i in range(0)]

        for interval in intervals:
            if interval[0]>right:
                if place == False:
                    res.append([left, right])
                    place = True
                res.append(interval)
            elif interval[1]<left:
                res.append(interval)
            else:
                left=min(left, interval[0])
                right=max(right, interval[1])
        if place==False:
            res.append([left, right])
        return res