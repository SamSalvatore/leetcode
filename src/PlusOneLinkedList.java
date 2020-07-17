/**
 * @(#)PlusOneLinkedList.java, 7月 17, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * LC 369
 * <p>
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example :
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 */
public class PlusOneLinkedList {

    /**
     * 思路。找到小于9的最低位节点，然后进行加1 。需要考虑几种情况
     * case1: ...-> 4-> 8 直接+1
     * case2: .. -> 4 -> 9 需要将4加1，并且后面的全部置为0
     * case3: 9->9->9  需要在前面补一个val =1 的头节点,然后将后面的节点的值全部置为0
     *
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; //前两步应该是ListNode的通用步骤了
        ListNode lastLessThan9Node = dummy; //最后一个小于9的节点
        ListNode tailNode = dummy; //链表的尾节点

        while (tailNode.next != null) {
            tailNode = tailNode.next;
            if (tailNode.val < 9) {
                lastLessThan9Node = tailNode;
            }
        }

        //case1: lastLessThan9Node是尾节点。 case1也可以合并到case2中
        if (lastLessThan9Node.next == null) {
            lastLessThan9Node.val++;
            return dummy.next;
        }


        //case2: lastLessThan9Node不是尾节点。可能是中间的节点或者是dummy节点
        lastLessThan9Node.val++;
        while (lastLessThan9Node.next != null) {
            lastLessThan9Node = lastLessThan9Node.next;
            lastLessThan9Node.val = 0;
        }

        //如果是 9 -> 9 -> 9的形式直接返回的是dummy 而不是dummy.next
        return dummy.val == 0 ? dummy.next : dummy;
    }


    /**
     * 思路：反转链表，然后+1，再反转链表；
     *
     * @param head
     * @return
     */
    public ListNode plusOne2(ListNode head) {
        head = reverseListNode(head);
        ListNode cur = head; //维护链表的头节点位置
        int carry = 1; //进位
        while (cur != null) {
            carry = carry + cur.val;
            cur.val = carry % 10;
            carry = carry / 10;
            cur = cur.next;
        }

        head = reverseListNode(head);

        ListNode dummy = new ListNode(1);
        dummy.next = head;
        return carry == 1 ? dummy : dummy.next;
    }

    //反转链表，要求闭着眼睛能写出来
    public ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }
}
