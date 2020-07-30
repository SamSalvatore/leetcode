/**
 * @(#)ConvertSortedListToBinarySearchTree.java, 7月 25, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * 参考 https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/discuss/35476/Share-my-JAVA-solution-1ms-very-short-and-concise.
     *
     * 思路和将有序数组转换为二叉搜索树一模一样。
     * 唯一的区别是，对于数组，我们可以使用start + (end- start) / 2;
     * 对于链表，我们需要使用fast,slow 两个指针，当fast指针走到最后的时候，slow刚好走到中间
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode tHead = new TreeNode(slow.val);
        tHead.left = helper(head, slow);
        tHead.right = helper(slow.next, tail);

        return tHead;
    }


    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }

        return backTrack(head, null);
    }

    private TreeNode backTrack(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }

        if (head == tail) {
            return new TreeNode(head.val);
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slowPre = slow;
            slow = slow.next;
        }

        TreeNode tHead = new TreeNode(slow.val);
        if (slowPre != null) {
            tHead.left = backTrack(head, slowPre);
        }

        tHead.right = backTrack(slow.next, tail);

        return tHead;
    }

}