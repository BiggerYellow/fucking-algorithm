#include <stdio.h>
#include <vector>
#include "TreeNode.cpp"
#include <stack>

using namespace std;

class Solution {
public:

	vector<int> res;
	

	vector<int> inorderTraversal(TreeNode* root){
		if (!root) {
			return res;
		}
		inorderTraversal(root->left);
		res.push_back(root->val);
		inorderTraversal(root->right);
		return res;
	}


	vector<int> inorderTraversal(TreeNode* root) {
		vector<int> res;
		stack<TreeNode*> stack;
		while (root != nullptr || !stack.empty()) {
			while (root != nullptr) {
				stack.push(root);
				root = root->left;
			}
			root = stack.top();
			stack.pop();
			res.push_back(root->val);
			root = root->right;
		}
		return res;
	}

};