#include "ListNode.cpp"
class Solution {
public:
	ListNode* getIntersectionNode(ListNode *headA, ListNode *headB) {
		if (headA == nullptr || headB == nullptr) {
			return nullptr;
		}

		ListNode *indexA = headA;
		ListNode *indexB = headB;

		while (indexA != indexB)
		{
			indexA = indexA == nullptr ? headB : indexA->next;
			indexB = indexB == nullptr ? headA : indexB->next;
		}

		return indexA;
	}
};