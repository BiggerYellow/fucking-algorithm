#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	bool isCovered(vector<vector<int>>& ranges, int left, int right)
	{
		vector<int> arr = vector<int>(52);
		for (int i = 0; i < ranges.size(); i++)
		{
			arr[ranges[i][0]]++;
			arr[ranges[i][1] + 1]--;
		}
		vector<int> sum = vector<int>(52);
		sum[0] = arr[0];
		for (int i = 1; i <= 51; i++)
		{
			sum[i] = sum[i - 1] + arr[i];
		}
		for (int i = left; i <=right; i++)
		{
			if (sum[i] <= 0) {
				return false;
			}
		}
		return true;
	}
};