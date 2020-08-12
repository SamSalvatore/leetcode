/**
 * @(#)InsertionSortList.java, 8月 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 147. 对链表进行插入排序
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class InsertionSortList {

    /**
     * 参考 https://leetcode.com/problems/insertion-sort-list/discuss/46573/Clean-Java-solution-using-a-fake-head
     * the basic idea is make a new list, and insert node form old list into the new list one by one.
     *
     * 在插入排序过程中，可能会遇到
     * p.val < cur.val, while p.next.val > cur.val.
     * p: 1 - > 3
     * cur: 2 -> 5
     *
     * to make the list sorted:
     * cur.next = p.next
     * p.next = cur
     * cur = next
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newListNode = new ListNode(0);
        ListNode prev;
        while(head != null) {
            ListNode temp = head.next;

            //每一次都从前往后找，因此需要每一次都重置节点prev
            prev = newListNode;
            //pre.val < head.val < prev.next.val;
            while (prev.next != null && prev.next.val <= head.val) {
                prev = prev.next;
            }

            //insert head between prev and prev.next
            head.next = prev.next;
            prev.next = head;
            head = temp;
        }

        return newListNode.next;
    }
}