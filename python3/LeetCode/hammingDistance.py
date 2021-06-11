class Solution:
    def hammingDistance(self, x:int,y:int) ->int:
        temp = x^y
        res = 0
        while temp:
            temp&=(temp-1)
            res+=1
        return res


    def hammingDistance1(self, x:int,y:int) ->int:
        temp = x^y
        res=0
        while temp:
            res += temp&1
            temp>>=1
        return res


if __name__ == '__main__':
    print(Solution().hammingDistance1(1,4))