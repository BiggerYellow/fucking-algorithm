class Solution:
    def balancedStringSplit(self, s:str) -> int:
        res=0
        countL=0
        countR=0
        for i in (s):
            if i == 'L':
                countL+=1
            else:
                countR+=1
            if countR==countL:
                res+=1
                countR=countL=0
        return res