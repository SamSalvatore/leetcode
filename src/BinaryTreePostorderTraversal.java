/**
 * @(#)BinaryTreePostorderTraversal.java, 8月 11, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author fucf
 *
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreePostorderTraversal {


    /**
     * 迭代版本
     * 前序遍历 中 -> 左 -> 右
     *  => 中 -> 右 -> 左 stack后压入右孩子(后进先出)
     *  => reverse (list.addFist)
     *
     * 后续遍历 左 -> 右 -> 中
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
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
     * 递归版本
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        postHelper(res, root);
        return res;
    }

    private void postHelper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        postHelper(res, root.left);
        postHelper(res, root.right);
        res.add(root.val);
    }

}