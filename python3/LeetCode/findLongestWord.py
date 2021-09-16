from typing import List


class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        dictionary.sort(key=lambda x: (-len(x), x))
        for dic in dictionary:
            left=0
            right=0
            while left<len(dic) and right<len(s):
                if dic[left] == s[right]:
                    left+=1
                    right+=1
                else:
                    right+=1

            if left == len(dic):
                return dic

        return ""