package main

import "sort"

func main() {
	points := [][]int{{-2147483646,-2147483645},{2147483646,2147483647}}
	print(findMinArrowShots(points))

}

func findMinArrowShots(points [][]int) int {
	sort.Slice(points, func(i, j int) bool {
		if points[i][1]<points[j][1] {
			return true
		}else {
			return false
		}
	})
	res :=1
	end:=points[0][1]
	for i:=1;i<len(points);i++ {
		if points[i][0] > end {
			res++
			end = points[i][1]
		}
	}

	return res
}
