package com.example.leetcode;

import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/3/18 9:08
 * @description
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverseBetween {
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
        ListNode reverse = reverseBetween1(node1,2,4);
        System.out.println(reverse);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = new ListNode(-1);
        newNode.next = head;

        ListNode pre = newNode;
        for (int i=1;i<left;i++){
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

    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        //初始化头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        //第一步：从虚拟节点遍历到left-1步，来到left节点的前一个节点
        for (int i=0;i<left-1;i++){
            pre = pre.next;
        }
        //第二步：从pre在走到right-left+1步，来到right节点
        ListNode rightNode = pre;
        for (int i=0;i<right-left+1;i++){
            rightNode = rightNode.next;
        }

        //第三步：截取链表
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        //第四步：切断连接
        pre.next = null;
        rightNode.next = null;

        //第五步：翻转链表
        reverse(leftNode);

        //第六步：重新连接
        pre.next = rightNode;
        leftNode.next = cur;
        return dummy.next;
    }

    public static void reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

}
