class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        hasWord = False
        res=0
        for i in range(len(s)-1,-1,-1):
            if s[i]!=' ':
                res+=1
                hasWord=True
            else:
                if hasWord:
                    break
                continue
        return res

if __name__ == '__main__':
    s = "Hello World"
    print(Solution().lengthOfLastWord(s))