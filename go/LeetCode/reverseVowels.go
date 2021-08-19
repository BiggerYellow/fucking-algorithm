package main

import "strings"

func main() {
	
}

func reverseVowels(s string) string {
	t := []byte(s)
	left:=0
	right:=len(s)-1
	for left<right {
		for left<right && !strings.Contains("aeiouAEIOU", string(t[left])) {
			left++
		}
		for left<right && !strings.Contains("aeiouAEIOU", string(t[right])) {
			right--
		}
		if left<right {
			t[left],t[right] = t[right], t[left]
			left++
			right--
		}
	}
	return string(t)
}
