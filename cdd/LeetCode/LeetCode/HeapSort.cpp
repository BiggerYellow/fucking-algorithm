#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	vector<int> heapSort(vector<int>& nums)
	{
		int len = nums.size();
		//½¨¶Ñ
		for (int i = len/2; i >=0; i--)
		{
			sink(nums, i, len);
		}
		//ÅÅÐò
		while (len>1)
		{
			swap(nums, 0, --len);
			sink(nums, 0, len);
		}
		return nums;
	}

	void sink(vector<int>& nums, int k, int len)
	{
		while (2*k+1<len)
		{
			int j = 2 * k + 1;
			while (j+1<len && nums[j+1]> nums[j])
			{
				j++;
			}
			if (nums[j]<nums[k])
			{
				break;
			}
			swap(nums, j, k);
			k = j;
		}
	}

	void swap(vector<int>& nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
};