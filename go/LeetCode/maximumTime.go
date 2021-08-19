package main

func main() {
	
}

func maximumTime(time string)  string {
	temp :=[]byte(time)
	if temp[0] == '?'{
		if temp[1]=='?' || temp[1]<'4' {
			temp[0]='2'
		}else {
			temp[0]='1'
		}
	}
	if temp[1] == '?' {
		if temp[0] == '2' {
			temp[1] = '3'
		}else {
			temp[1] = '9'
		}
	}
	if temp[3]=='?' {
		temp[3]='5'
	}
	if temp[4]=='?' {
		temp[4]='9'
	}
	return string(temp)
}
