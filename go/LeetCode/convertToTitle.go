package main

func main() {
	
}

func convertToTitle(columnNumber int) string {
	res := []byte{}

	for columnNumber>0 {
		columnNumber--
		res = append(res, 'A'+byte(columnNumber%26))
		columnNumber/=26
	}

	for i,n:=0,len(res); i<n/2;i++ {
		res[i],res[n-1-i] = res[n-1-i], res[i]
	}
	return string(res)
}
