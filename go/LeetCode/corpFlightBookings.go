package main

func main() {
	
}

func corpFlightBookings(bookings [][]int, n int) []int {
	res := make([]int, n)
	for _,v :=range bookings{
		res[v[0]-1]+=v[2]
		if v[1]<n {
			res[v[1]]-=v[2]
		}
	}
	for i:=1;i<n;i++ {
		res[i] +=res[i-1]
	}
	return res
}