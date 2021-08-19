package main

func main() {
	print(countArrangement(2))
}


func countArrangement(n int) int {
	visit := make([]bool, n+1)
	res:=0

	var dfs func(i int)
	dfs = func(i int) {
		if i == n+1 {
			res++
			return
		}
		for num:=1;num<=n;num++ {
			if !visit[num] && (num%i==0 || i%num==0) {
				visit[num] = true
				dfs(i+1)
				visit[num]= false
			}
		}
	}
	dfs(1)
	return res
}
