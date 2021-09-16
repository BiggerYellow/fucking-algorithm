package main

func main() {
	
}

func insert(intervals [][]int, newInterval []int) [][]int {
	left:=newInterval[0]
	right:=newInterval[1]
	place:=false

	cache:=make([][]int, 0)

	for _,v :=range intervals{
		if v[0]>right {
			if !place {
				temp:=[]int{left, right}
				cache = append(cache, temp)
				place=true
			}
			cache = append(cache, v)
		}else if v[1]<left {
			cache = append(cache, v)
		}else {
			left = min12(left, v[0])
			right = max12(right, v[1])
		}
	}
	if !place {
		temp := []int{left, right}
		cache =append(cache, temp)
	}
	return cache
}

func min12(x int, y int) int {
	if x<y {
		return x
	}
	return y
}

func max12(x int, y int) int {
	if x<y {
		return y
	}
	return x
}