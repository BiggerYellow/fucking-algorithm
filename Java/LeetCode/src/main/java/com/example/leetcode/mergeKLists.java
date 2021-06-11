package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2020/12/23 9:14
 * @description
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class mergeKLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        node7.next = node8;

        ListNode[] lists = new ListNode[]{node1, node4, node7};
        ListNode node = mergeKLists2(lists);
        System.out.println(node);

    }

    //分治法
    public static ListNode mergeKLists2(ListNode[] lists) {
        return split(lists, 0, lists.length-1);
    }

    //遍历法
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length ==0) return null;
        ListNode res = lists[0];
        for (int i=1;i<lists.length;i++){
            res = merge2(res, lists[i]);
        }
        return res;
    }

    //分治 两两链表合并
    public static ListNode split(ListNode[] lists, int left, int right){
        if (left == right) return lists[left];
        int mid = left + (right-left)/2;
        ListNode node1 = split(lists, left, mid);
        ListNode node2 = split(lists, mid+1, right);
        return merge2(node1, node2);

    }

    //两个链表 双指针合并
    public static ListNode merge(ListNode node1, ListNode node2){
        ListNode res = new ListNode(-1);
        ListNode prev = res;
        while (node1!=null && node2!=null){
            if (node1.val < node2.val){
                prev.next = new ListNode(node1.val);
                node1 = node1.next;
            }else {
                prev.next = new ListNode(node2.val);
                node2 = node2.next;
            }
            prev = prev.next;
        }
        if (node1 !=null){
            prev.next = node1;
        }

        if (node2 !=null){
            prev.next = node2;
        }
        return res.next;
    }

    //两个链表 递归合并
    public static ListNode merge2(ListNode node1, ListNode node2){
        if (node1==null){
            return node2;
        }else if (node2==null){
            return node1;
        }else if (node1.val<node2.val){
            node1.next = merge2(node1.next, node2);
            return node1;
        }else {
            node2.next = merge2(node1, node2.next);
            return node2;
        }
    }
}
