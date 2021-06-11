package main

import "fmt"

func main() {
	fmt.Print(hammingDistance1(1,4))
}

func hammingDistance(x int, y int) int {
	temp:= x^y
	res :=0
	for temp!=0 {
		temp&=(temp-1)
		res++
	}
	return res
}

func hammingDistance1(x int, y int) int {
	temp:=x^y
	res:=0
	for temp!=0 {
		res+=temp&1
		temp>>=1
	}
	return res
}


