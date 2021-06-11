package main

import "fmt"

func main() {
	encoded := []int{6,5,4,6}
	fmt.Print(decode(encoded))
}

func decode(encoded []int) []int {
	n := len(encoded)
	array := make([]int, n+1)

	arr:=0
	for i:=1;i<=n+1;i++{
		arr^=i
	}
	en:=0
	for i:=1;i<n;i+=2 {
		en^=encoded[i]
	}
	array[0] = arr^en
	for i:=1;i<=n;i++ {
		array[i] = array[i-1]^encoded[i-1]
	}
	return array
}
