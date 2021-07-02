package main

import "sort"

func main() {
	cost := []int{1,3,2,4,1}
	print(maxIceCream1(cost, 7))
}

func maxIceCream(costs []int,coins int) int {
	sort.Ints(costs)
	res:=0
	for i:=0;i<len(costs);i++ {
		if coins-costs[i] >=0 {
			res++
			coins-=costs[i]
		}else {
			break
		}
	}
	return res
}

func maxIceCream1(costs []int, coins int) int {
	temp := make([]int, 100001)
	for i:=0;i<len(costs);i++ {
		temp[costs[i]]++
	}

	res:=0
	for i:=1;i<100001;i++ {
		if coins>=i {
			count := min4(temp[i], coins/i)
			res+=count
			coins-=count*i
		}else {
			break
		}
	}
	return res
}

func min4(x int, y int) int {
	if x<y {
		return x
	}else {
		return y
	}
}


