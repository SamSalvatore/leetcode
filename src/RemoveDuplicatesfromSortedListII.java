/**
 * @(#)RemoveDuplicatesfromSortedListII.java, 7月 17, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 * <p>
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy; // pre指向重建后的链表
        dummy.next = head;

        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                int sameNumber = pre.next.val;
                while (pre.next != null && pre.next.val == sameNumber) {
                    pre.next = pre.next.next; //跳过重复元素
                }
            } else {
                pre = pre.next; //pre指向的当前节点为uniq节点。直接移动pre节点
            }
        }

        return dummy.next;
    }


    /**
     * 思路2: 依次遍历head节点。
     * a.如果遇到重复节点，则跳过重复节点(pre.next = uniq)
     * b. 如果没遇到重复节点，则直接移动pre指针(pre = pre.next)
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy; // pre指向重建后的链表
        dummy.next = head;

        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }

            if (pre.next == head) {
                //说明head为uniq节点
                pre = pre.next;
                head = head.next;
            } else {
                //head为duplicated节点的最后一个
                pre.next = head.next;
                head = head.next;
            }
        }

        return dummy.next;
    }

}