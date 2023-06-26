#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
	vector<int>& nums;

public:
		Solution(vector<int>& nums) : nums(nums) {}

		int pick(int target) {
			int res;
			for (int i = 0, count = 0;i < nums.size(); i++) {
				if (nums[i] == target)
				{
					++count;
					if (rand() % count == 0)
					{
						res = i;
					}
				}
			}
			return res;
		}
};


class Solution {
	vector<int> selectK(vector<int>& nums, int k)
	{
		vector<int> res(k);
		for (int i = 0;i < k;i++)
		{
			res[i] = nums[i];
		}
		
		int count = k;
		int i = k;
		while (i < nums.size())
		{
			++count;
			int j = rand() % count;
			if (j < k)
			{
				res[j] = nums[i];
			}
		}
		return res;
	}
};



int pick() {

	printf("hello world");
	return 1;
}

