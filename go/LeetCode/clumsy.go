package main

import "fmt"

func main() {
	fmt.Print(clumsy(10))
}

func clumsy(N int) int {
	val:=[]int{}
	index := 1
	for i:=N;i>0;i-- {
		if index%4 == 1 {
			if len(val) == 0 {
				val = append(val, i)
			}else {
				val = append(val, -i)
			}
		}
		if index%4 == 2 {
			val[len(val)-1]*=i
		}
		if index%4 == 3 {
			val[len(val)-1]/=i
		}
		if index%4 == 0 {
			val[len(val)-1]+=i
		}
		index++
	}
	res:=0
	for _,v :=range val {
		res+=v
	}
	return res
}