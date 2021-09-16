#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
public:
	void quickSort(vector<int>& nums, int left, int right) 
	{
		if (left<right)
		{
			int temp = division(nums, left, right);
			quickSort(nums, left, temp - 1);
			quickSort(nums, temp + 1, right);
		}
	}

	int division(vector<int>& nums, int left, int right)
	{
		int base = nums[left];
		while (left<right)
		{
			while (left < right && nums[right] >= base) {
				right--;
			}
			nums[left] = nums[right];
			while (left < right && nums[left] <= base) {
				left++;
			}
			nums[right] = nums[left];
		}
		nums[left] = base;
		return left;
	}

	void quickSort1(vector<int>& nums, int left, int right)
	{
		if (right<=left)
		{
			return;
		}
		int base = division1(nums, left, right);
		quickSort1(nums, left, base - 1);
		quickSort1(nums, base + 1, right);

	}

	int division1(vector<int>& nums, int left, int right)
	{
		int i = left;
		int j = right;
		int base = nums[left];
		while (true)
		{
			i += 1;
			while (base >= nums[i++])
			{
				if (i==right)
				{
					break;
				}
			}
			j -= 1;
			while (base <= nums[--j])
			{
				if (j==left)
				{
					break;
				}
			}
			if (j<=i)
			{
				break;
			}
			swap(nums, i, j);
		}
		swap(nums, left, j);
		return j;
	}

	void swap(vector<int>& nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
};