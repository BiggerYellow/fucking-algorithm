class Solution:
    def countArrangement(self, n:int) -> int:
        visit = [False]*(n+1)
        res = 0
        def dfs(i:int)->int:
            nonlocal res
            if i==n+1:
               res+=1
            for num in range(1, n+1):
                if (visit[num] == False and (num%i==0 or i%num==0)):
                    visit[num] = True
                    dfs(i+1)
                    visit[num] = False
        dfs(1)
        return res


if __name__ == '__main__':
    print(Solution().countArrangement(2))