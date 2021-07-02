import collections
from typing import List


class Solution:
    ##bfs
    def openLock(self, deadends:List[str], target:str) -> int:
        queue = collections.deque()
        queue.append("0000")
        visit = set()
        visit.add("0000")
        step =0
        while(queue):
            length = len(queue)
            for i in range(length):
                cur = queue.popleft()
                if cur in deadends:
                    continue
                if cur == target:
                    return step

                for i in range(4):
                    addCur = self.add(cur, i)
                    if addCur not in visit:
                        queue.append(addCur)
                        visit.add(addCur)
                    minCur = self.min(cur,i)
                    if minCur not in visit:
                        queue.append(minCur)
                        visit.add(minCur)

            step+=1
        return -1

    ##双向bfs
    def openLock1(self, deadends:List[str], target:str) -> int:
        queue1 = set()
        queue1.add("0000")
        queue2 = set()
        queue2.add(target)
        visit = set()
        step=0
        while(queue2 and queue1):
            temp = set()
            for cur in queue1:
                if cur in deadends:
                    continue
                if cur in queue2:
                    return step
                visit.add(cur)

                for i in range (4):
                    addCur = self.add(cur, i)
                    if addCur not in visit:
                        temp.add(addCur)
                    minCur = self.min(cur, i)
                    if minCur not in visit:
                        temp.add(minCur)

            step+=1
            queue1=queue2
            queue2=temp
        return -1


    def add(self, num:str,index:int) ->str:
        num = list(num)
        temp = (int(num[index])+1)%10
        num[index]=str(temp)
        return "".join(num)

    def min(self, num:str,index:int) ->str:
        num = list(num)
        temp = (int(num[index])-1)%10
        num[index]=str(temp)
        return "".join(num)


if __name__ == '__main__':
    deadends = ["0201","0101","0102","1212","2002"]
    target = "0202"
    print(Solution().openLock1(deadends, target))