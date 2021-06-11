package main

import (
	"fmt"
	"strconv"
)

func main() {
	//nums := []int{3,30,34,5,9}
	nums := []int{111311, 1113}
	//nums := []int{0,0,0,0}
	fmt.Print(largestNumber(nums))
}

func largestNumber(nums []int) (res string) {
	strings :=make([]string, len(nums))
	for k,v := range nums {
		strings[k] = strconv.Itoa(v)
	}
	for i:=0;i<len(strings);i++ {
		for j:=len(strings)-1;j>i;j-- {
			if compare(strings[j-1], strings[j]) {
				temp:=strings[j-1]
				strings[j-1] = strings[j]
				strings[j] = temp
			}
		}
	}
	for _,v := range strings{
		res += v
	}
	if res[0:1] == "0" {
		return "0"
	}
	return res
}

func compare(num1 string, num2 string) bool {
	len1 := len(num1)
	len2 := len(num2)
	if len1==len2 {
		for i:=0;i<len1;i++ {
			if int(num1[i]) > int(num2[i]) {
				return false
			}
		}
		return true
	}else if len1<len2 {
		for i:=0;i<len1;i++ {
			if int(num1[i]) > int(num2[i]) {
				return false
			}
		}
		if num2[len1:len1+1] == "0" {
			return false
		}
		return true
	}else {
		for i:=0;i<len2;i++ {
			if int(num2[i]) > int(num1[i]) {
				return true
			}
		}
		if num1[len2:len2+1] == "0" {
			return false
		}
		return false
	}
}
