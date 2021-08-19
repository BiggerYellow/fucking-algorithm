#include <vector>
#include <stdio.h>
#include <algorithm>

using namespace std;

class Solution {
public:
	int lengthOfLIS(vector<int>& nums) 
	{
		int len = (int)nums.size();
		vector<int> dp(len);
		int res = 1;
		dp[0] = 1;
		for (int i = 1; i < nums.size(); i++)
		{
			dp[i] = 1;
			for (int j = i; i >= 0; i--)
			{
				if (nums[i] > nums[j])
				{
					dp[i] = max(dp[i], dp[j] + 1);
				}
			}
			res = max(res, dp[i]);
		}
		return res;
	}

	int lengthOfLIS1(vector<int>& nums) {
		int n = (int)nums.size();
		if (n == 0) {
			return 0;
		}
		vector<int> dp(n, 0);
		for (int i = 0; i < n; ++i) {
			dp[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (nums[j] < nums[i]) {
					dp[i] = max(dp[i], dp[j] + 1);
				}
			}
		}
		return *max_element(dp.begin(), dp.end());
	}


	int lengthOfLIS2(vector<int>& nums)
	{
		int length = nums.size();
		vector<int> tail(length + 1);
		int res = 0;
		for (int i = 0; i < length; i++)
		{
			int l, r = 0, res;
			while (l<r)
			{
				int mid = (l + r) / 2;
				if (tail[mid] < nums[i])
				{
					r = mid + 1;
				}
				else 
				{
					l = mid;

				}
			}
			tail[l] = nums[i];
			if (res == r)
			{
				res++;
			}
		}
		return res;
	}
};