#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
public:
	void mergeSort(vector<int>& nums)
	{
		int length = nums.size();
		vector<int> temp(length);
		sort(nums, 0, length - 1, temp);
	}

	void sort(vector<int>& nums, int lo, int hi, vector<int>& temp)
	{
		if (hi<=lo)
		{
			return;
		}
		int mid = (hi + lo) / 2;
		sort(nums, lo, mid, temp);
		sort(nums, mid + 1, hi, temp);
		merge(nums, lo, mid, hi, temp);
	}

	void merge(vector<int>& nums, int lo, int mid, int hi, vector<int>& temp)
	{
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++)
		{
			temp[k] = nums[k];
		}
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid) 
			{
				nums[k] = temp[j++];
			}
			else if (j>hi)
			{
				nums[k] = temp[i++];
			}
			else if (temp[j]<temp[i])
			{
				nums[k] = temp[j++];
			}
			else
			{
				nums[k] = temp[i++];
			}
		}
	}
};