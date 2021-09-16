#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
public:
	int chalkReplacer(vector<int>& chalk, int k) {
		long total =0;
		for (int i = 0; i < chalk.size(); i++)
		{
			total += chalk[i];
		}

		int mod = k % total;

		for (int i = 0; i < chalk.size(); i++)
		{
			if (mod-chalk[i]<0) {
				return i;
			}
			mod -= chalk[i];
		}
		return -1;
	}
};