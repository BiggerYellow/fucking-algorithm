#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	int maxFrequency(vector<int>& nums, int k)
	{
		sort(nums.begin(), nums.end());
		int res = 1;
		int count = 0;
		for (int left=0, right = 1; right < nums.size(); right++)
		{
			count += (long long) (nums[right] - nums[right - 1]) * (right - left);
			while (count > k) 
			{
				count -= nums[right] - nums[left++];
			}
			res = max(res, right-left+1);
		}
		return res;
	}
};