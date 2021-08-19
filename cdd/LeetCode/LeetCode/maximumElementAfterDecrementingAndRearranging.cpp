#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	int maximumElementAfterDecrementingAndRearranging(vector<int>& arr)
	{
		sort(arr.begin(), arr.end());
		arr[0] = 1;
		int len = arr.size();
		for (int i = 1; i < len; i++)
		{
			if (arr[i]-arr[i-1]>0)
			{
				arr[i] = arr[i - 1] + 1;
			}
		}
		return arr[len - 1];
	}

};