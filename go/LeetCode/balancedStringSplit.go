package main

func main() {
	
}

func balancedStringSplit(s string) int {
	res :=0
	countL :=0
	countR :=0
	for _,v := range s {
		if v == 'L' {
			countL++
		}else {
			countR++
		}
		if countL==countR {
			 res++
			 countL=0
			 countR=0
		}
	}
	return res
}
