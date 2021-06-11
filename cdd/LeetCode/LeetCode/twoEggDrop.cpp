#include <vector>
#include <stdio.h>

using namespace std;

class Soultion {
public:
	int twoEggDrop(int n) 
	{
		vector<vector<int>> dp(n + 1, vector<int>(2, INT_MAX));
		dp[0][0] = 0;
		for (int i = 1; i <=n; i++)
		{
			dp[i][0] = i;
		}

		for (int i = 1; i <= n; i++)
		{
			for (int k = 1; k <=i; k++)
			{
				dp[i][1] = min(dp[i][1], max(dp[k - 1][0] + 1, dp[i - k][1] + 1));
			}
		}
		return dp[n][1];
	}
};
