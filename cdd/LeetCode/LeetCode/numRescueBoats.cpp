#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	int numRescueBoats(vector<int>& people, int limit) {
		sort(people.begin(), people.end());
		int left = 0;
		int right = people.size() - 1;
		int res = 0;
		while (left<=right)
		{
			if (people[left]+people[right]<=limit)
			{
				left++;
			}
			res++;
			right--;
		}
		return res;
	}
};