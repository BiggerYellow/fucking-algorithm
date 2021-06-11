from ListNode import ListNode


class Solution:
    def getIntersectionNode(self, headA:ListNode, headB:ListNode)->ListNode:
        if headA == None | headB == None:
            return None
        indexA = headA
        indexB = headB
        while indexA!=indexB:
            if indexA == None:
                indexA = headB
            else:
                indexA = indexA.Next

            if indexB == None:
                indexB = headA
            else:
                indexB = indexB.next

        return indexA