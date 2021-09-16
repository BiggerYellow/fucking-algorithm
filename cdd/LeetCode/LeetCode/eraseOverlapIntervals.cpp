#include <vector>
#include <stdio.h>
#include <algorithm>

using namespace std;

class Solution {
public:
	int eraseOverlapIntervals(vector<vector<int>>& intervals)
	{
		sort(intervals.begin(), intervals.end(), [](const auto& u, const auto& v) {
			return u[1] < v[1];
			});
		int res = 0;
		int end = intervals[0][1];
		for (int i = 1; i < intervals.size(); i++)
		{
			if (intervals[i][0]<end)
			{
				res++;
			}
			else {
				end = intervals[i][1];
			}
		}
		return res;
	}
};