#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	int majorityElement(vector<int>& nums) 
	{
		int candidate = -1;
		int count = 0;
		for (int i = 0; i < nums.size();i++) 
		{
			if (count == 0)
			{
				candidate = nums[i];

			}
			if (nums[i] == candidate)
			{
				count++;
			}
			else
			{
				count--;
			}
		}

		count = 0;
		for (int i = 0; i < nums.size(); i++)
		{
			if (nums[i] == candidate)
			{
				count++;
			}
		}
		return count * 2 >= nums.size() ? candidate : -1;
	}
};