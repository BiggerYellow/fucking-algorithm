from typing import List


class Solution:
    def corpFlightBookings(self, bookings:List[List[int]],n:int) -> List[int]:
        res = [0]*n
        for i in range (0, len(bookings)):
            res[bookings[i][0]-1]+=bookings[i][2]
            if bookings[i][1]<n:
                res[bookings[i][1]]-=bookings[i][2]

        for i in range (1,n):
            res[i]+=res[i-1]
        return res