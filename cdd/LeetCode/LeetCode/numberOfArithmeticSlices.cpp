#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	int numberOfArithmeticSlices(vector<int>& nums)
	{
		int length = nums.size();
		if (length == 1)
		{
			return 0;
		}
		int diff = nums[0] - nums[1];
		int count = 0;
		int res = 0;
		for (int i = 2; i < length; i++)
		{
			if (nums[i-1]-nums[i]==diff)
			{
				count++;
			}
			else
			{
				diff = nums[i - 1] - nums[i];
				count = 0;
			}
			res += count;
		}
		return res;
	}
};
