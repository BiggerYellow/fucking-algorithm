from typing import List


class Solution:
    def allPathsSourceTarget(self, graph:List[List[int]]) -> List[List[int]]:
        res = list()
        track = list()
        track.append(0)

        def dfs(src:int):
            if src == len(graph)-1:
                res.append(track[:])
                return
            for gra in graph[src]:
                track.append(gra)
                dfs(gra)
                track.pop()

        dfs(0)
        return res