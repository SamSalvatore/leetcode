/**
 * @(#)ValidateBinarySearchTree.java, 7月 21, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Stack;

/**
 * @author fucf
 *
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class ValidateBinarySearchTree {

    /**
     * 参考https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
     * https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
     * 思路: 二叉搜索树中序遍历的结果为:
     * root.val > root.left.val
     * root.val < root.right.val
     * <p>
     * 我们可以利用这个性质，递归遍历该二叉树，如果遇到当前节点不满足这一性质，则return false， 最后return true
     *
     * @param root
     * @return
     */

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!helper(root.left)) {
            return false;
        }

        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;

        return helper(root.right);
    }


    /**
     * 思路2: 栈迭代
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }

            pre = root;
            root = root.right;
        }

        return true;
    }


}