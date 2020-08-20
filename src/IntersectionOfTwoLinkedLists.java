/**
 * @(#)IntersectionOfTwoLinkedLists.java, 8月 14, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoLinkedLists {

    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = getListNodeSize(headA);
        int lenB = getListNodeSize(headB);
        if (lenA > lenB) {
            while (lenA != lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenA != lenB) {
                headB = headB.next;
                lenB--;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getListNodeSize(ListNode head) {
        if (head == null) {
            return 0;
        }

        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    /**
     * 解法二 https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
     *
     * "构建" 新的链表 la = listNodeA + listNodeB 和 lb = listNodeB + listNodeA 比较
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null ? headB : a.next);
            b = (b == null ? headA : b.next);
        }

        return a;
    }
}