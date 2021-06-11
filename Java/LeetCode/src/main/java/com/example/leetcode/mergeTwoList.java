package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/12/21 16:12
 * @description
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class mergeTwoList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;
        System.out.println(mergeTwoLists2(node1, node4));
    }

    //双指针法
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        //当l1和l2中都存在剩余元素时
        while (l1!=null && l2 !=null){
            //如果l1的值大于l2的值 则将l2的值放置新链表后面并将l2往后移动一格  反之亦然
            if (l1.val > l2.val){
                if (res == null){
                    res = new ListNode(l2.val);
                }else {
                    res = addLast(res, l2.val);
                }
                l2 = l2.next;
            }else {
                if (res == null){
                    res = new ListNode(l1.val);
                }else {
                    res = addLast(res, l1.val);
                }
                l1 = l1.next;
            }
        }

        //当经过一轮遍历后 l1中还有剩余元素 则将l1中所有元素添加到后面
        while (l1!=null){
            if (res == null){
                res = new ListNode(l1.val);
            }else {
                res = addLast(res, l1.val);
            }
            l1=l1.next;
        }
        //当经过一轮遍历后 l2中还有剩余元素 则将l2中所有元素添加到后面
        while (l2!=null){
            if (res == null){
                res = new ListNode(l2.val);
            }else {
                res = addLast(res, l2.val);
            }
            l2=l2.next;
        }

        return res;
    }

    //在链表尾部添加元素
    public static ListNode addLast(ListNode node, int val){
        ListNode temp = node;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        return node;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //新建一个空链表
        ListNode node = new ListNode(-1);
        ListNode prev = node;
        //当l1和l2都不为空时进行两两比较
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                prev.next = l2;
                l2 = l2.next;
            }else {
                prev.next = l1;
                l1 = l1.next;
            }
            //将头结点往后移动一格
            prev = prev.next;
        }

        //因为数组有序 直接将剩余的链表添加到尾部
        prev.next = l1==null?l2:l1;
        return node.next;
    }

    //递归用法
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    }
