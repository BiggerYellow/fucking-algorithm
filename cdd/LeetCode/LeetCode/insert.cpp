#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        bool place = false;

        vector<vector<int>> res(0, vector<int>(2));

        for (int i = 0; i < intervals.size(); i++)
        {
            if (intervals[i][0]>right)
            {
                if (!place)
                {
                    res.push_back({ left, right });
                    place = true;
                }
                res.push_back(intervals[i]);
            }
            else if (intervals[i][1]<left)
            {
                res.push_back(intervals[i]);
            }
            else
            {
                left = min(left, intervals[i][0]);
                right = max(right, intervals[i][1]);
            }
        }
        if (!place)
        {
            res.push_back({ left, right });
        }
        return res;
    }
};