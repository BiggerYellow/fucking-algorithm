#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
public:

	vector<vector<int>> res;
		
	vector<int> track;

	vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph)
	{
		track.push_back(0);
		dfs(graph, 0, graph.size() - 1);
		return res;

	}

	void dfs(vector<vector<int>>& graph, int src, int end) {
		if (src == end)
		{
			res.push_back(track);
		}

		for (int i = 0; i < graph[src].size(); i++)
		{
			int temp = graph[src][i];
			track.push_back(temp);
			dfs(graph, temp, end);
			track.pop_back();
		}
	}
};