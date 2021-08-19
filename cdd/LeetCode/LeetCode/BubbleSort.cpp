#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
public:
	//内部正序
	void bubbleSort(vector<int>& nums)
	{
		int len = nums.size();
		for (int i = 0; i < len - 1; i++)
		{
			for (int j = 0; j < len-i-1; j++)
			{
				if (nums[j + 1] < nums[j])
				{
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
	}

	//内部逆序
	void bubbleSort1(vector<int>& nums)
	{
		int len = nums.size();
		for (int i = 0; i < len; i++)
		{
			for (int  j = len-1; j >i; j--)
			{
				if (nums[j-1]>nums[j])
				{
					int temp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = temp;
				}
			}
		}
	}
};
