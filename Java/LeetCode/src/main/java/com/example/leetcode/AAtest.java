package com.example.leetcode;

import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/3/19 10:58
 * @description
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class AAtest {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        ListNode node = reverseNode1(node1, 2, 4);
        ListNode node = reverse1(node1);
        System.out.println(node);
    }

    public static ListNode reverseNode1(ListNode head, int left, int right){
        ListNode newNode = new ListNode(-1);
        newNode.next = head;

        ListNode pre = newNode;
        for (int i=0;i<left-1;i++){
            pre = pre.next;
        }
        head = pre.next;
        for (int i=left;i<right;i++){
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return newNode.next;
    }

    public static ListNode reverseNode(ListNode head, int left,int right){
        ListNode newNode = new ListNode(-1);
        newNode.next = head;

        ListNode pre = newNode;
        for (int i=0;i<left-1;i++){
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i=0;i<right-left+1;i++){
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;
        return newNode.next;
    }

    public static void reverse(ListNode node){
        ListNode pre =null;
        ListNode cur = node;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static ListNode reverse1(ListNode node){
        if (node.next == null) return node;
        ListNode last = reverse1(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }
}
