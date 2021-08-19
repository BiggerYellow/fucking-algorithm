#include <vector>
#include <stdio.h>
#include <string>
#include <unordered_set>
#include <queue>

using namespace std;

class solution {
public:
	int openLock(vector<string>& deadends, string target) {
		unordered_set<string> dead(deadends.begin(), deadends.end());
		queue<string> queue;
		queue.push("0000");
		unordered_set<string> visit;
		int step = 0;
		while (queue.size())
		{
			int size = queue.size();
			for (int i = 0; i < size; i++)
			{
				string cur = queue.front();
				queue.pop();
				if (dead.find(cur) != dead.end())
				{
					continue;
				}
				if (target==cur)
				{
					return step;
				}

				for (int j = 0; j < 4; j++)
				{
					string addCur = add(cur, j);
					if (visit.find(addCur) == visit.end())
					{
						queue.push(addCur);
						visit.insert(addCur);
					}
					string minCur = min(cur, j);
					if (visit.find(minCur) == visit.end()) {
						queue.push(minCur);
						visit.insert(minCur);
					}
				}
			}
			step++;
		}
		return -1;
	}

	int openLock1(vector<string>& deadends, string target) {
		unordered_set<string> dead(deadends.begin(), deadends.end());
		unordered_set<string> visit;
		vector<string> queue1;
		vector<string> queue2;
		queue1.push_back("0000");
		queue2.push_back(target);
		int step = 0;
		while (queue1.size() && queue2.size()) 
		{
			vector<string> temp;
			for (int i = 0; i < queue1.size(); i++)
			{
				string cur = queue1[i];
				if (dead.find(cur) == dead.end())
				{
					continue;
				}
				if (find(queue2, cur))
				{
					return step;
				}
				
				for (int j = 0; j < 4; j++)
				{
					string addCur = add(cur, j);
					if (visit.find(addCur) == visit.end())
					{
						temp.push_back(addCur);
					}
					string minCur = min(cur, j);
					if (visit.find(minCur) == visit.end())
					{
						temp.push_back(minCur);

					}
				}
			}
			step++;
			queue1 = queue2;
			queue2 = temp;
		}
		return -1;
	}

	bool find(vector<string>& arr, string cur) 
	{
		for (int i = 0; i < arr.size(); i++)
		{
			if (cur == arr[i])
			{
				return true;
			}
		}
		return false;
	}


	string add(string num, int index) {
		if (num[index] == '9')
		{
			num[index] = '0';
		}
		else
		{
			num[index]++;
		}
		return num;
	}

	string min(string num, int index) {
		if (num[index] == '0')
		{
			num[index] = '9';
		}
		else
		{
			num[index]++;
		}
		return num;
	}
};