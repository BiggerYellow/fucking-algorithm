from typing import List


class Soultion:
    def chalkReplacer(self, chalk:List[int], k:int)->int:
        total = sum(chalk)
        mod = k%total
        for i in range(0, len(chalk)):
            if mod - chalk[i]<0:
                return i
            mod-=chalk[i]
        return -1