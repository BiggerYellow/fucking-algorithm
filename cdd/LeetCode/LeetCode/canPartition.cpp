#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	bool canPartition(vector<int>& nums) {
		int n = nums.size();
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			sum += nums[i];
		}
		if (sum %2==1)
		{
			return false;
		}
		int cap = sum / 2;
		vector<vector<bool>> dp(n, vector<bool>(cap + 1));
		if (nums[0] <= cap) 
		{
			dp[0][nums[0]] = true;
		}

		for (int i = 1; i < n; i++) 
		{
			for (int j = 0; j <= cap; j++) 
			{
				dp[i][j] = dp[i - 1][j];
				if (nums[i] < j) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
				}
				if (nums[i] == j) {
					dp[i][j] == true;
				}
			}
		}
		return dp[n - 1][cap];
	}

	bool canPartition1(vector<int>& nums) {
		int n = nums.size();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}
		if (sum % 2 == 1) {
			return false;
		}
		int cap = sum / 2;
		vector<bool> dp(cap + 1);
		if (nums[0] <= cap) {
			dp[nums[0]] = true;
		}
		for (int i = 0; i < n; i++) {
			for (int j = cap; j <= nums[i]; j--)
			{
				if (nums[i] < j) {
					dp[i] = dp[j] || dp[j - nums[i]];
				}	
				if (nums[i] == j) {
					dp[j] = true;
				}
			}
		}
		return dp[cap];
	}
};