package main

import "sort"

func main() {
	intervals := [][]int{{15,18},{1,3},{2,6},{8,10}}
	res := merge(intervals)
	print(res)
}

func merge(intervals [][]int) [][]int {
	res := make([][]int, 0)
	for i:=range res{
		res[i] = make([]int, 2)
	}
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0]<intervals[j][0]
	})
	end := intervals[0][1]
	temp := intervals[0]
	for i:=1;i<len(intervals);i++ {
		if intervals[i][1]<=end {
			continue
		}else if intervals[i][0]<=end && intervals[i][1] >=end {
			end = intervals[i][1]
			temp[1] = intervals[i][1]
		}else if intervals[i][0]>end {
			res = append(res, temp)
			end = intervals[i][1]
			temp = intervals[i]
		}
	}
	res = append(res, temp)
	return res
}
