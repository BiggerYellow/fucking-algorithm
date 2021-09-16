#include <vector>
#include <stdio.h>
#include <algorithm>

using namespace std;

class Solution {
public:
	int findMinArrowShots(vector<vector<int>>& points)
	{
		sort(points.begin(), points.end(), [](const auto& u, const auto& v) {
			return u[1]<v[1];
			});
		int res = 1;
		int end = points[0][1];
		for (int i = 1; i < points.size(); i++)
		{
			if (points[i][0]>end)
			{
				res++;
				end = points[i][1];
			}
		}
		return res;
	}
};