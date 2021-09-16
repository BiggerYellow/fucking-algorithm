package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/9/2 0:14
 * @description
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class getKthFromEnd {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode kthFromEnd = getKthFromEnd1(listNode1, 2);
        System.out.println(kthFromEnd);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        int count =0;
        while (temp!=null){
            count++;
            temp = temp.next;
        }
        int index = count-k;
        while (index>0){
            head = head.next;
            index--;
        }
        return head;
    }

    public static ListNode getKthFromEnd1(ListNode head, int k) {
        int right=0;
        ListNode temp = head;
        while (right<k){
            right++;
            temp = temp.next;
        }
        while (temp != null){
            temp = temp.next;
            head = head.next;
        }
        return head;
    }
    }
