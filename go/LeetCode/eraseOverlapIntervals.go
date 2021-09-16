package main

import "sort"

func main() {
	intervals := [][]int{{1,2}, {2,3}, {3,4}, {1,3}}
	print(eraseOverlapIntervals(intervals))
}

func eraseOverlapIntervals(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1]<intervals[j][1]
	})
	res :=0
	end :=intervals[0][1]
	for i:=1;i<len(intervals);i++ {
		if intervals[i][0] < end {
			res++
		}else {
			end = intervals[i][1]
		}
	}
	return res
}
