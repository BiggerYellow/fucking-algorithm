#include <stdio.h>
#include <vector>

using namespace std;


class Solution {
public:
	int totalHammingDistance(vector<int>& nums) {
		int n = nums.size();
		int res = 0;
		for (int i = 0; i < 31; i++)
		{
			int temp = 0;
			for (int j = 0; j < n; j++)
			{
				temp += (nums[j] >> i) & 1;
			}
			res += temp * (n - temp);
		}
		return res;
	}
};
