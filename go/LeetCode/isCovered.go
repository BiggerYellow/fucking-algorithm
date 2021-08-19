package main

func main() {
	
}

func isCovered(ranges [][]int, left int, right int) bool {
	arr := make([]int, 52)
	for i:=0;i<len(ranges);i++ {
		arr[ranges[i][0]]++
		arr[ranges[i][1]+1]--
	}
	sum := make([]int, 52)
	sum[0] = arr[0]
	for i:=1;i<=51;i++ {
		sum[i] = sum[i-1]+arr[i]
	}
	for i:=left;i<=right;i++ {
		if sum[i]<=0 {
			return false
		}
	}
	return true
}
