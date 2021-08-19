package main

func main() {
	
}

func lengthOfLIS(nums []int) int {
	length:=len(nums)
	dp := make([]int , length+1)
	dp[0]=1
	res:=1
	for i:=1;i<length;i++ {
		dp[i]=1
		for j:=i;j>=0;j-- {
			if nums[i] > nums[j] {
				dp[i] = max1234(dp[i], dp[j]+1)
			}
		}
		res  =max(res, dp[i])
	}
	return res
}

func max1234(x int, y int) int {
	if x>y {
		return x
	}else {
		return y
	}
}

func lengthOfLIS1(num []int) int {
	length := len(num)
	tail := make([]int, length+1)
	res:=0
	for _,v := range num{
		i,j:=0,res
		for i<j {
			mid := (i+j)/2
			if tail[mid] < v {
				i = mid+1
			}else {
				j=mid
			}
		}
		tail[i]=v
		if res == j {
			res++
		}
	}
	return res
}