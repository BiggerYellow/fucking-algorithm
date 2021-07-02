#include <vector>
#include <stdio.h>

using namespace std;

class solution {
public:
	int coinChange(vector<int>& coins, int amount) {
		vector<int> dp = vector<int>(amount + 1, amount+1);
		dp[0] = 0;
		for (int i = 0; i < coins.size(); i++)
		{
			for (int j = coins[i]; j <= amount; j++) 
			{
				dp[j] = min(dp[j], dp[j - coins[i]] + 1);
			}
		}
		if (dp[amount] == amount+1)
		{
			return -1;
		}
		else {
			return dp[amount];
		}
	
	}

};