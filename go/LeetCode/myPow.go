package main

func main() {
	print(myPow1(2.00000,10))
}

//快速幂+递归
func myPow(x float64, n int) float64 {
	N := int64(n)
	if N>0 {
		return quickMul(x, N)
	}else {
		return 1.0/quickMul(x,-N)
	}
}

func quickMul(x float64, N int64) float64  {
	if N==0 {
		return 1.0
	}
	y:= quickMul(x, N/2)
	if N%2==0 {
		return y*y
	}else {
		return y*y*x
	}
}

//快速幂+迭代
func myPow1(x float64, n int) float64  {
	N:=int64(n)
	if N>0 {
		return quickMul1(x, N)
	}else {
		return 1.0/quickMul1(x, -N)
	}
}

func quickMul1(x float64, N int64) float64  {
	res :=1.0
	y := x
	for N>0 {
		if N%2==1 {
			res*=y
		}
		y*=y
		N/=2
	}
	return res
}
