from typing import List


class Solution:
    def maxIceCream(self, costs:List[int], coins:int) -> int:
        costs.sort()
        res=0
        for cost in costs:
            if coins -cost>0:
                res+=1
                coins-=cost
            else:
                break
        return res


    def maxIceCream(self, costs:List[int], coins:int) -> int:
        temp = [0]*100001
        for cost in costs:
            temp[cost]+=1
        res=0
        for i in range(1, 100001):
            if coins>=i:
                count = min(temp[i], coins//i)
                res+=count
                coins-=count*i
            else:
                break
        return res