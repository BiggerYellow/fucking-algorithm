import string


class Solution:
    def longestCommonSubsequence(self, text1:string, text2:string) ->int:
        len1 = len(text1)
        len2 = len(text2)
        dp = [[0]*(len2+1) for i in range (len1+1)]
        for i in range (1, len1+1):
            for j in range (1, len2+1):
                if text1[i-1] == text2[j-1]:
                    dp[i][j] = dp[i-1][j-1]+1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])

        return dp[len1][len2]

