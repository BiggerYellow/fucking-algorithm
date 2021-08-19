#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
public:
	int search(vector<int>& nums, int target)
	{
		int i = 0;
		int j = nums.size()-1;
		while (i <= j) 
		{
			int mid = i + (j - i) / 2;
			if (nums[mid] <= target)
			{
				i = mid + 1;
			}
			else
			{
				j = mid - 1;
			}
		}
		int right = i;
		if (j>=0 && nums[j] != target)
		{
			return 0;
		}
		i = 0;
		j = nums.size()-1;
		while (i<=j)
		{
			int mid = i + (j - i) / 2;
			if (nums[mid] < target) 
			{
				i = mid + 1;
			}
			else
			{
				j = mid - 1;
			}
		}
		int left = j;
		return right - left - 1;
	}
};