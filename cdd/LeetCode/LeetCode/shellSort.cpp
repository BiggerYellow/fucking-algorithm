#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	void shellSort(vector<int>& nums)
	{
		int len = nums.size();
		int factor = 2;
		int h = 1;
		while (h<len/factor)
		{
			h = h * factor + 1;
		}

		while (h>=1)
		{
			for (int i = h; i < len; i++)
			{
				for (int j = i; j >=h; j-=h)
				{
					if (nums[j]< nums[j-h])
					{
						swap(nums, j, j - h);
					}
				}
			}
			h /= factor;
		}
	}

	void swap(vector<int>& nums, int i,int j) 
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
};