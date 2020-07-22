/**
 * @(#)ReverseLinkedListII.java, 7月 19, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 * <p>
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * prev
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < m; i++) {
            prev = prev.next;
            head = head.next;
        }

        ListNode pre = null;
        ListNode reverseHead = head;
        for (int i = 0; i < n - m; i++) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }


        prev.next = pre;
        reverseHead.next = head;


        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < m; i++) {
            prev = prev.next;
            head = head.next;
        }

        ListNode start = head;
        ListNode then = start.next;
        for (int i = 0; i < n - m; i++) {
            ListNode temp = then.next;
            prev.next = then;
            then.next = start;
            then = temp;
        }

        return dummy.next;
    }

}