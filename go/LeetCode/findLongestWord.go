package main

import "sort"

func main() {
	
}

func findLongestWord(s string, dictionary []string) string {
	sort.Slice(dictionary, func(i, j int) bool {
		a,b :=dictionary[i], dictionary[j]
		return len(a)>len(b) || len(a) == len(b) && a<b
	})

	for _,v := range dictionary{
		left:=0
		right:=0
		for left<len(v) && right<len(s) {
			if v[left] == s[right] {
				left++
				right++
			}else {
				right++
			}
		}
		if left == len(v) {
			return v
		}
	}
	return ""
}
