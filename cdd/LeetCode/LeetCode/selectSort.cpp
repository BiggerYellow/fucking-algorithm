#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	void selectSort(vector<int>& nums)
	{
		int length = nums.size();
		for (int i = 0; i < length; i++)
		{
			int min = i;
			for (int j = i+1; j < length; j++)
			{
				if (nums[min] > nums[j])
				{
					min = j;
				}
			}
			swap(nums, min, i);
		}
	}

	void swap(vector<int>& nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
};