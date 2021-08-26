#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	void radixSort(vector<int>& nums, int d)
	{
		int k = 0;
		int m = 1;
		int n = 1;
		int len = nums.size();
		vector<vector<int>> temp(10, vector<int>(len));
		vector<int> order(10);

		while (m<=d)
		{
			for (int i = 0; i < len; i++)
			{
				int lsd = (nums[i] / n) % 10;
				temp[lsd][order[lsd]++] = nums[i];
			}

			for (int i = 0; i < 10; i++)
			{
				if (order[i] !=0)
				{
					for (int j = 0; j < order[i]; j++) 
					{
						nums[k++] = temp[i][j];
					}
				}
				order[i] = 0;
			}
			k = 0;
			m++;
			n *= 10;
		}
	}
};