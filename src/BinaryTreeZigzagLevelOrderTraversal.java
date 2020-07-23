/**
 * @(#)BinaryTreeZigzagLevelOrderTraversal.java, 7月 22, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fucf
 *
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reversedOrder = false;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> list = new LinkedList<>(); //添加元素链表O(1). arrayList O(n)
            for (int i = 0 ; i < queueSize; i++) {
                root = queue.poll();
                if (reversedOrder) {
                    list.add(0, root.val);
                } else {
                    list.add(root.val);
                }

                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }

            res.add(list);
            reversedOrder = !reversedOrder;
        }

        return res;
    }
}