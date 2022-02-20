package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangchunchen
 * @date :Created in 2022/2/20 11:03
 * @description:
 * 6013. 合并零之间的节点 显示英文描述
 * 通过的用户数895
 * 尝试过的用户数920
 * 用户总通过次数897
 * 用户总提交次数952
 * 题目难度Medium
 * 给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
 *
 * 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。
 *
 *  返回修改后链表的头节点 head 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [0,3,1,0,4,5,2,0]
 * 输出：[4,11]
 * 解释：
 * 上图表示输入的链表。修改后的链表包含：
 * - 标记为绿色的节点之和：3 + 1 = 4
 * - 标记为红色的节点之和：4 + 5 + 2 = 11
 * 示例 2：
 *
 *
 * 输入：head = [0,1,0,3,0,2,2,0]
 * 输出：[1,3,4]
 * 解释：
 * 上图表示输入的链表。修改后的链表包含：
 * - 标记为绿色的节点之和：1 = 1
 * - 标记为红色的节点之和：3 = 3
 * - 标记为黄色的节点之和：2 + 2 = 4
 *
 *
 * 提示：
 *
 * 列表中的节点数目在范围 [3, 2 * 105] 内
 * 0 <= Node.val <= 1000
 * 不 存在连续两个 Node.val == 0 的节点
 * 链表的 开端 和 末尾 节点都满足 Node.val == 0
 */
public class mergeNodes {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        System.out.println(mergeNodes(node1));
    }

    public static ListNode mergeNodes(ListNode head) {
        List<ListNode> cache = new ArrayList<ListNode>();
        int temp = 0;
        while(head.next != null){
            if(head.val == 0 && temp != 0){
                cache.add(new ListNode(temp));
                temp = 0;
            }else{
                temp += head.val;
            }
            head = head.next;
        }
        cache.add(new ListNode(temp));
        for(int i=1;i<cache.size();i++){
            cache.get(i-1).next = cache.get(i);
        }
        return cache.get(0);
    }
}
