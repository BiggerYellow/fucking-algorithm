#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<vector<int>> merge(vector<vector<int>>& intervals)
	{
		vector<vector<int>> res(0, vector<int>(2));
		sort(intervals.begin(), intervals.end(), [](const auto& u, const auto& v) {
			return u[0] < v[0];
			});
		int end = intervals[0][1];
		vector<int> temp = intervals[0];
		for (int i = 1; i < intervals.size(); i++)
		{
			if (intervals[i][1]<=end)
			{
				continue;
			}
			else if (intervals[i][0]<=end && intervals[i][1]>=end)
			{
				end = intervals[i][1];
				temp[1] = intervals[i][1];
			}
			else if (intervals[i][0] > end)
			{
				res.push_back(temp);
				end = intervals[i][1];
				temp = intervals[i];
			}		
		}
		res.push_back(temp);
		return res;
	}
};