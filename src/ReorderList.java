/**
 * @(#)ReorderList.java, 8月 10, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {

    /**
     * 参考 https://leetcode.com/problems/reorder-list/discuss/45147/Java-solution-with-3-steps
     * 思路 1->2->3->4->5  => 1->2->3->5->4 => 1->5->2->4->3.
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = null;

        ListNode secondHalfNode = reverse(slow);
        ListNode firstHalfNode = head;
        while (firstHalfNode != null) {
            ListNode firstHalfNext = firstHalfNode.next;
            ListNode secondHalfNext = secondHalfNode.next;

            firstHalfNode.next = secondHalfNode;
            if (firstHalfNext == null) {
                break;
            }

            secondHalfNode.next = firstHalfNext;

            firstHalfNode = firstHalfNext;
            secondHalfNode = secondHalfNext;
        }
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}