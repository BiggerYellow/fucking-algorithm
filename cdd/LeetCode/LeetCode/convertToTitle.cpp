#include <stdio.h>
#include <string>

using namespace std;

class solution {
public:
	string convertToTitle(int columnNumber) 
	{
		string res;
		while (columnNumber >0)
		{
			--columnNumber;
			res += columnNumber % 26 + 'A';
			columnNumber /= 26;
		}
		reverse(res.begin(), res.end());
		return res;
	}

};