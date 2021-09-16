from typing import List


class Solution:
    def merge(self, intervals:List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x:x[0])
        res = [[0]*2 for i in range(0)]
        end = intervals[0][1]
        temp = intervals[0]
        for i in range(1, len(intervals)):
            if intervals[i][1]<=end:
                continue
            elif intervals[i][0]<=end and intervals[i][1]>=end:
                temp[1] = intervals[i][1]
                end = intervals[i][1]
            elif end< intervals[i][0]:
                res.append(temp)
                end = intervals[i][1]
                temp = intervals[i]

        res.append(temp)
        return res

if __name__ == '__main__':
    intervals =  [[1,3],[2,6],[8,10],[15,18]]
    print(Solution().merge(intervals))
