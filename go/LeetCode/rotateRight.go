package main

func main() {
}

func rotateRight(head *ListNode, k int) *ListNode {
	if k==0 || head ==nil || head.Next == nil {
		return head
	}
	count:=1
	temp := head
	for temp.Next!=nil {
		temp = temp.Next
		count++
	}

	len:= count - k%count
	if len == count {
		return head
	}

	temp.Next = head

	for len>0 {
		temp=temp.Next
		len--
	}

	res := temp.Next
	temp.Next=nil
	return res
}

func rotateRight1(head *ListNode, k int) *ListNode {
	if k==0||head== nil||head.Next==nil{
		return head
	}

	count:=0
	temp:=head
	for temp != nil {
		temp = temp.Next
		count++
	}

	k = k%count
	fast := head
	slow := head

	for k>0 {
		fast = fast.Next
		k--
	}

	for fast.Next!=nil {
		fast=fast.Next
		slow=slow.Next
	}
	fast.Next = head
	head = slow.Next
	slow.Next=nil
	return head
}