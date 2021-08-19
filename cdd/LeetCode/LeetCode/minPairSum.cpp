#include <algorithm>
#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	int minPairSum(vector<int>& nums)
	{
		sort(nums.begin(), nums.end());
		int length = nums.size();
		int res = 0;
		for (int i = 0; i < length/2; i++)
		{
			res = max(res, nums[i]+nums[length-1-i]);
		}
		return res;
	}
};