class Solution {
public:
	int hammingDistance(int x, int y) {
		int temp = x ^ y;
		int res = 0;
		while (temp != 0)
		{
			temp &= (temp - 1);
			res++;
		}
		return res;
	}

	int hammingDistance1(int x, int y) {
		int temp = x ^ y;
		int res = 0;
		while (temp != 0) {
			res += temp & 1;
			temp >>= 1;
		}
		return res;
	}

};
