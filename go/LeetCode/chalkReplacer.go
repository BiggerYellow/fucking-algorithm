package main

func main() {
	
}

func chalkReplacer(chalk []int, k int) int {
	sum:=0
	for _,v := range chalk{
		sum+=v
	}
	mod:=k%sum
	for i:=0;i<len(chalk);i++ {
		if mod-chalk[i]<0 {
			return i
		}
		mod-=chalk[i]
	}
	return -1
}