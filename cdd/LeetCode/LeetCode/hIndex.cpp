#include <vector>
#include <stdio.h>

using namespace std;

class solution {
public:
	int hIndex(vector<int>& citations)
	{
		int len = citations.size();
		int res = 0;
		for (int i = 0; i < len; i++)
		{
			if (citations[i] >= len - i) 
			{
				return len - i;
			}
		}
		return res;
	}

	int hIndex1(vector<int>& citations)
	{
		int len = citations.size();
		int left = 0, right = len - 1;
		while (left<=right) 
		{
			int mid = left + (right - left) / 2;
			if (citations[mid] >= len - mid)
			{
				right = mid - 1;
			}
			else
			{
				left = mid + 1;
			}
		}
		return len - left;
	}
};