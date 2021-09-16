from typing import Optional

from ListNode import ListNode


class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k==0 or head is None or head.next is None:
            return head

        count = 1
        temp = head
        while not temp.next is None:
            temp = temp.next
            count+=1

        len = count-k%count
        if len == count:
            return head

        temp.next = head

        while len>0:
            temp = temp.next
            len-=1

        res = temp.next
        temp.next = None
        return res

    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k==0 or head is None or head.next is None:
            return head

        count =0
        temp = head
        while not temp is None:
            temp = temp.next
            count+=1

        k=k%count
        fast = head
        slow = head

        while k>0:
            fast = fast.next
            k-=1

        while not fast.next is None:
            fast = fast.next
            slow = slow.next

        fast.next = head
        head = slow.next
        slow.next = None
        return head

