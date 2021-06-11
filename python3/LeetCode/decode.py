from typing import List

class Solution:
    def decode(self, encoded:List[int]) -> List[int]:
        n = len(encoded)
        array = [0] * (n+1)
        arr = 0
        for i in range(1, n+2):
            arr^=i
        en = 0
        for i in range(1, n, 2):
            en^=encoded[i]

        start = arr^en
        array[0] = start
        for i in range(1, n+1):
            array[i] = array[i-1]^encoded[i-1]

        return array



if __name__ == '__main__':
    encoded = [6,5,4,6]
    print(Solution().decode(encoded))