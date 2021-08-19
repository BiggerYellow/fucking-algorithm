#include <vector>
#include <stdio.h>
#include <algorithm>

using namespace std;

class solution {
public:
	int maxIceCream(vector<int>& costs, int coins) 
	{
		sort(costs.begin(), costs.end());
		int res = 0;
		for (int i = 0; i < costs.size(); i++)
		{
			if (coins - costs[i]>=0)
			{
				res++;
				coins -= costs[i];
			}
			else
			{
				break;
			}
		}
		return res;
	}



	int maxIceCream1(vector<int>& costs, int coins)
	{
		vector<int> temp = vector<int>(100001);
		for (int i = 0; i < costs.size(); i++)
		{
			temp[costs[i]]++;
		}

		int res = 0;
		for (int i = 1; i < 100001; i++)
		{
			if (coins >= i) 
			{
				int count = min(temp[i], coins / i);
				res += count;
				coins -= count * i;
			}
			else
			{
				break;
			}

		}
		return res;
	}
};