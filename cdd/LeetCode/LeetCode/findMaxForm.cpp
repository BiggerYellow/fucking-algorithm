#include <vector>
#include <stdio.h>
#include <string>

using namespace std;

class Solution {
public:
	int findMaxForm(vector<string>& strs, int m, int n) {
		int len = strs.size();
		vector<vector<vector<int>>> dp(len + 1, vector<vector<int>>(m + 1, vector<int>(n + 1)));
		for (int i = 1; i < len; i++)
		{
			vector<int>&& zerosOnes = getZerosOnes(strs[i - 1]);
			int count0 = zerosOnes[0];
			int count1 = zerosOnes[1];
			for (int j = 0; j <=m; j++)
			{
				for (int k = 0; k <=n; k++)
				{
					dp[i][j][k] = dp[i - 1][j][k];
					if (j>=count0 && k>=count1)
					{
						dp[i][j][k] = max(dp[i-1][j][k], dp[i - 1][j - count0][k - count1] + 1);
					}
				}
			}
		}
		return dp[len][m][n];
	}

	vector<int> getZerosOnes(string& str) {
		vector<int> zerosOnes(2);
		int length = str.length();
		for (int i = 0; i < length; i++) {
			zerosOnes[str[i] - '0']++;
		}
		return zerosOnes;
	}

};