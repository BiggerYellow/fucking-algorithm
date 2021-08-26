package main

import "sort"

func main() {
	
}

func numRescueBoats(people []int, limit int) int {
	sort.Ints(people)
	left:=0
	right:=len(people)-1
	res:=0
	for left<=right {
		if people[left]+people[right] <= limit {
			left++
		}
		res++
		right--
	}
	return res
}