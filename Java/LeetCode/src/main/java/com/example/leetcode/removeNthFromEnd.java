package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/12/18 15:02
 * @description
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class removeNthFromEnd {
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
        System.out.println(remove2(listNode1,2));
//        System.out.println(removeNthFromEnd(listNode1,2));
//        System.out.println(removeNthFromEnd(listNode1,1));
//        addLast(listNode1,2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        //1.计算出链表的总长度
        ListNode temp = head;
        int size=0;
        while (temp!=null){
            ++size;
            temp=temp.next;
        }
        //计算出需要移除的链表位置i
        int i = size - n;
        int number=0;
        ListNode node = null;
        ListNode res = head;
        //当n=1表示每次移除链表的最后一个元素
        if (n==1){
            ListNode node1 = removeLast(res);
            return node1;
        }
        //当i=0表示每次移除链表的第一个元素
        if (i==0){
            return removeFirst(res);
        }

        //两种情况都不是则是移除链表的中间元素，找到指定位置删除
        while (res!=null){
            ++number;
            if (number == i){
                res.next = res.next.next;
                break;
            }
            res=res.next;
        }

        return head;
    }

    public static ListNode addLast(ListNode node, int val){
        ListNode temp = node;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next = new ListNode(val);
        return temp;
    }

    public static ListNode removeLast(ListNode node){
        if (node.next == null){
            node=null;
            return node;
        }
        ListNode temp=node;
        while(temp.next!=null&&temp.next.next!=null){
            temp=temp.next;//找到倒数第二个结点
        }
        temp.next=null;//倒数第二个结点的next赋null
        return node;
    }

    public static ListNode removeFirst(ListNode node){
        node = node.next;
        return node;
    }

    //双指针法
    public static ListNode remove2(ListNode head, int n){
        //第一个指针开始位置
        ListNode first = head;
        //第二个指针开始位置
        ListNode second = head;
        //将第一个指针移动n个位置
        for (int i=0;i<n;++i){
            first = first.next;
        }
        //如果为first为null，表明删除的是头结点
        if (first == null){
            return head.next;
        }
        //两个指针同时遍历，直到first的下一个节点为null时停止
        while (first.next !=null){
            first = first.next;
            second = second.next;
        }
        //将第二个指针的下个节点跳过
        second.next = second.next.next;
        return head;
    }
}
