package main

type ListNode struct {
	Val int
	Next *ListNode
}

func main() {
	
}

func getIntersectionNode(headA,headB *ListNode) *ListNode {
	visit := map[*ListNode]bool{}
	for temp:=headA;temp!=nil;temp = temp.Next {
		visit[temp] = true
	}

	for temp:=headB;temp!=nil;temp = temp.Next {
		if visit[temp] {
			return temp
		}
	}
	return nil
}

func getIntersectionNode1(headA,headB *ListNode) *ListNode {
	if headA==nil || headB==nil {
		return nil
	}
	indexA := headA
	indexB := headB
	for indexA !=indexB {
		if indexA == nil {
			indexA = headB
		}else {
			indexA = indexA.Next
		}

		if indexB == nil {
			indexB = headA
		}else {
			indexB = indexB.Next
		}
	}
	return indexA
}