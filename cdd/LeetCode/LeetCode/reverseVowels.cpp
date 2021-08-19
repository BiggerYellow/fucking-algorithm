#include <stdio.h>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
	string reverseVowels(string s)
	{
		auto isVowel = [vowels = "aeiouAEIOU"s](char ch){
			return vowels.find(ch) != string::npos;
		};

		int left = 0, right = s.size() - 1;
		while (left<right)
		{
			while (left < right && !isVowel(s[left]) )
			{
				left++;
			}
			while (left<right && !isVowel(s[right]))
			{
				right--;
			}
			if (left<right)
			{
				char temp = s[left];
				s[left] = s[right];
				s[right] = temp;
			}
			left++;
			right--;
		}
		return s;
	}
};