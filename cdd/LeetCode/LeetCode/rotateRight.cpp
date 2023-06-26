#include <stdio.h>
#include "ListNode.cpp"

using namespace std;

class Solution {
public:
	ListNode* rotateRight(ListNode* head, int k) {
		if (k==0||head ==NULL || head->next == NULL)
		{
			return head;
		}

		int count = 1;
		ListNode* temp = head;
		while (temp->next != NULL)
		{
			temp = temp->next;
			count++;
		}

		int len = count - k % count;
		if (len == count)
		{
			return head;
		}

		temp->next = head;

		while (len-- > 0) {
			temp = temp->next;
		}

		ListNode* res = temp->next;
		temp->next = NULL;
		return res;
	}

	ListNode* rotateRight1(ListNode* head, int k) {
		if (k==0||head==NULL||head->next==NULL)
		{
			return head;
		}
		int count = 0;
		ListNode* temp = head;
		while (temp != NULL)
		{
			temp = temp->next;
			count++;
		}

		k = k % count;
		ListNode* fast = head;
		ListNode* slow = head;

		while (k-- > 0) {
			fast = fast->next;
		}

		while (fast->next != NULL)
		{
			fast = fast->next;
			slow = slow->next;
		}

		fast->next = head;
		head = slow->next;
		slow->next = NULL;
		return head;
	}
};