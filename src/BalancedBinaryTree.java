/**
 * @(#)BalancedBinaryTree.java, 7月 25, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *  返回 false 。
 */
public class BalancedBinaryTree {

    /**
     * 参考 https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
     *
     * 解题思路:借助计算二叉搜索树高度函数
     * 时间复杂度O(n^2)
     *
     * 可使用从下往下遍历的方法使其time space降低至O(n)
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getTreeNodeHeight(root.left) - getTreeNodeHeight(root.right)) <= 1
        && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int getTreeNodeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getTreeNodeHeight(root.left), getTreeNodeHeight(root.right)) + 1;
    }


    /**
     * 解法2
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getTreeHeight(root) != -1;
    }

    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
    }

}