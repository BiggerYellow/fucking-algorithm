#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	void insertSort(vector<int>& nums)
	{
		int length = nums.size();
		for (int i = 1; i < length; i++)
		{
			for (int j= i; j>0; j--)
			{
				if (nums[j] < nums[j - 1]) {
					swap(nums, j, j - 1);
				}
				
			}
		}
	}

	void swap(vector<int>& nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
};