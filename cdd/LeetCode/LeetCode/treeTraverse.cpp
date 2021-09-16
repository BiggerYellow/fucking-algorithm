#include <stdio.h>
#include <vector>
#include <queue>
#include "TreeNode.cpp"

using namespace std;

class Solution {
public:

	vector<int> res;

	vector<int> sort(TreeNode* node)
	{
		dfs(node);
		return res;
	}

	void dfs(TreeNode* node)
	{
		if (node)
		{
			//1.先序遍历
			res.push_back(node->val);
			dfs(node->left);
			//2.中序遍历
			res.push_back(node->val);
			dfs(node->right);
			//3.后序遍历
			res.push_back(node->val);
		}
	}

	vector<int> sortBFS(TreeNode* node)
	{
		queue<TreeNode*> queue;
		queue.push(node);
		while (!queue.empty())
		{
			int size = queue.size();
			for (int i = 0; i < size; i++)
			{
				TreeNode* pop = queue.front();
				queue.pop();
				res.push_back(pop->val);
				if (pop->left)
				{
					queue.push(pop->left);
				}
				if (pop->right)
				{
					queue.push(pop->right);
				}
			}
		}
		return res;
	}
};