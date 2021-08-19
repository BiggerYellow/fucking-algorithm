from ListNode import ListNode


class Solution:
    def getIntersectionNode(self, headA:ListNode, headB:ListNode)->ListNode:
        indexA = headA
        indexB = headB
        while indexA!=indexB:
            indexA = indexA.next if indexA else headB
            indexB = indexB.next if indexB else headA
        return indexA