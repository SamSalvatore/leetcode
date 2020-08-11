/**
 * @(#)BinaryTreePreorderTraversal.java, 8月 11, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @author fucf
 *
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreePreorderTraversal {

    /**
     * 参考 https://leetcode.com/problems/binary-tree-preorder-traversal/discuss/45468/3-Different-Solutions
     * 递归版
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        preHelper(res, root);
        return res;
    }

    private void preHelper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preHelper(res, root.left);
        preHelper(res, root.right);
    }


    /**
     * 迭代写法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return res;
    }
}