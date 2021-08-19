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
};