#include <stdio.h>
#include <string>

using namespace std;

class Solution {
public:
	int balancedStringSplit(string s) {
		int res = 0;
		int countL = 0;
		int countR = 0;
		for (int i = 0; i < s.size(); i++)
		{
			if (s[i] == 'L')
			{
				countL++;

			}
			else {
				countR++;
			}
			if (countL==countR)
			{
				res++;
				countL = countR = 0;
			}
		}
		return res;
	}
};