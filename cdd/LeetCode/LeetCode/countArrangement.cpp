#include <vector>
#include <stdio.h>

using namespace std;

class Solution {
public:
	int countArrangement(int n)
	{
		vector<bool> visit(n + 1);
		int res = 0;
		dfs(1, n, res, visit);
		return res;
	}

	void dfs(int i, int n, int res, vector<bool>& visit) 
	{
		if (i==n+1)
		{
			res++;
			return;
		}
		for (int num = 1; num <= n; num++)
		{
			if (!visit[num] && (num%i==0 || i%num==0))
			{
				visit[num] = true;
				dfs(i + 1, n, res, visit);
				visit[num] = false;
			}
		}
	}

};