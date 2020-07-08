/**
 * @(#)RotateRight.java, 7月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * LC61
 */
class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = head;
        int listNodeLength = 1;
        while (dummy.next != null) {
            //1 -> 2 -> null
            dummy = dummy.next;
            listNodeLength++;
        }

        //首尾相连
        dummy.next = head;

        ListNode newTail = head;
        //链表新起点为head移动listNodeLength - k % listNodeLength 次
        // 1 -> 2 -> 3 -> null  移动2次得到  2 -> 3 -> 1 -> null
        // head.pre 需要移动listNodeLength - k % listNodeLength - 1 次
        for (int i = 0; i < listNodeLength - k % listNodeLength - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}