/**
 * @(#)PartitionList.java, 7月 19, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 86. 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode smallDummy = smallHead;
        ListNode bigDummy = bigHead;
        while (head != null) {
            if (head.val < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                bigHead.next = head;
                bigHead = bigHead.next;
            }
            head = head.next;
        }

        smallHead.next = bigDummy.next;
        bigHead.next = null;

        return smallDummy.next;
    }
}