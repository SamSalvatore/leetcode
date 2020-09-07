/**
 * @(#)CountCompleteTreeNodes.java, 9月 03, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author fucf
 *
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class CountCompleteTreeNodes {

    /**
     * 方法一: BFS. 计算节点的个数。 简单粗暴，适用于与任意二叉树
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res++;

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);

            }
        }

        return res;
    }

    /**
     * 法二: DFS。简单粗暴，适用于任意二叉树
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res++;
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        return res;
    }

    /**
     * 法三: 使用完全二叉树的性质
     * @param root
     * @return
     */
    public int countNodes3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root, true);
        int right = getHeight(root, false);
        if (left == right) {
            return (1 << left) - 1;
        }

        return 1 + countNodes3(root.left) + countNodes3(root.right);
    }

    private int getHeight(TreeNode root, boolean left) {
        int res = 0;
        while (root != null) {
            root = left ? root.left : root.right;
            res ++;
        }

        return res;
    }
}