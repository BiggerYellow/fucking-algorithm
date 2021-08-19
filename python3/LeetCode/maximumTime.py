class Solution:
    def maximumTime(self, time:str) ->str:
        [a, b, _, c, d] = time
        if a =='?':
            a=='2' if b=='?' or b <'4' else '1'
        if b=='?':
            b='3' if a=='2' else '9'
        if c=='?':
            c='5'
        if d=='?':
            d='9'
        return f'{a}{b}:{c}{d}'


if __name__ == '__main__':
    cache = dict()
    i=1
    m=1
    cache[(i, m)] =1
    print(cache)