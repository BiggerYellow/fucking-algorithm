package main

func main() {
	
}

func allPathsSourceTarget(graph [][]int) [][]int {
	res := make([][]int, 0)
	track := make([]int, 0)
	track = append(track, 0)
	var dfs func(int)
	dfs = func(src int) {
		if src == len(graph)-1 {
			res= append(res, append([]int(nil), track...))
		}
		for _,gra := range graph[src] {
			track = append(track, gra)
			dfs(gra)
			track = track[0:len(track)-1]
		}
	}
	dfs(0)
	return res
}