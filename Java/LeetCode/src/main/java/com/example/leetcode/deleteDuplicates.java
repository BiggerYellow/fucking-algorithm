package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunchen.huang
 * @description
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * @date 2024-01-15 19:23:24
 */
public class deleteDuplicates {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node7;
        System.out.println(deleteDuplicates(node1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1,head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null){
            if (temp.next.val == temp.next.next.val){
                int x = temp.next.val;
                while (temp.next !=null && temp.next.val == x){
                    temp.next = temp.next.next;
                }
            }else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}
