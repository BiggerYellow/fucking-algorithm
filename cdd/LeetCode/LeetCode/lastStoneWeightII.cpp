#include <vector>
#include <stdio.h>
#include <algorithm>


using namespace std;

class Solution {
public:
	int lastStoneWeightII(vector<int>& stones) {
		int sum = 0;
		for (int i = 0; i < stones.size(); i++)
		{
			sum += stones[i];
		}
		int cap = sum / 2;
		vector<vector<int>> dp(stones.size() + 1, vector<int>(cap + 1));
		for (int i = 1; i <= stones.size(); i++)
		{
			for (int j = 0;j <= cap;j++) 
			{
				if (j>=stones[i-1])
				{
					dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
				}
				else
				{
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return sum - dp[stones.size()][cap] * 2;
	}


	int lastStoneWeightII1(vector<int>& stones) {
		int sum = 0;
		for (int i = 0;i < stones.size();i++) 
		{
			sum += stones[i];
		}
		int cap = sum / 2;
		vector<int> dp(cap + 1);
		for (int i = 1; i < stones.size(); i++) 
		{
			for (int j = cap; j >=stones[i]; j--)
			{
				dp[j] = max(dp[j], dp[j - stones[i - 1]] + stones[i - 1]);
			}
		}
		return sum - dp[cap] * 2;
	}
};
