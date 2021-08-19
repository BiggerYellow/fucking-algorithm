package main

func main() {
	
}

func hIndex(citations []int) int {
	length := len(citations)
	for i,v := range citations{
		if v>= length-i {
			return length -i
		}
	}
	return 0
}

func hIndex1(citations [] int) int {
	length := len(citations)
	left:=0
	right:=length-1
	for left<=right {
		mid:=left+(right-left)/2
		if citations[mid] >= length-mid {
			right = mid-1
		}else {
			left = mid+1
		}
	}
	return length-left
}
