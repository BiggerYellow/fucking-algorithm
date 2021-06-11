from typing import List


class Solution:
    def xorQueries(self, arr:List[int], queries:List[List[int]]) -> List[int]:
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]
        for i in range(1, n):
            dp[i] = dp[i-1] ^ arr[i]

        res = [0] * len(queries)
        for i in range (0, len(queries)):
            if queries[i][0] == 0:
                res[i] = dp[queries[i][1]]
            else:
                res[i] = dp[queries[i][0]-1] ^ dp[queries[i][1]]

        return res




if __name__ == '__main__':
    arr = [1,3,4,8]
    queries =  [[0,1],[1,2],[0,3],[3,3]]
    print(Solution().xorQueries(arr, queries))