/**
 * @(#)ConstructBinaryTreeFromPreorderAndInorderTraversal.java, 7月 23, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 参考 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
     *
     * The basic idea is here:
     * Say we have 2 arrays, PRE and IN.
     * Preorder traversing implies that PRE[0] is the root node.
     * Then we can find this PRE[0] in IN, say it's IN[5].
     * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
     * Recursively doing this on subarrays, we can build a tree out of it :)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0,inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootNodeIndexInInOrder = 0; //根节点在中序数组中的位置
        for (int i = inStart; i<= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootNodeIndexInInOrder = i;
                break;
            }
        }

        /**
         * 前序遍历 preorder = [3,9,20,15,7]
         *                  l < -r -> r
         * 中序遍历 inorder = [9,3,15,20,7]
         *                   r    l + r
         *               preStart
         */
        root.left = helper(preStart + 1, inStart, rootNodeIndexInInOrder - 1, preorder, inorder);
        // newPreStart = x， x为右子树的起始位置。左子树的终止 - 左子树的开始 = (x -1) - (preStart + 1) = (rootNodeIndexInInOrder -1 ) - inStart
        root.right = helper(rootNodeIndexInInOrder + 1 + preStart - inStart, rootNodeIndexInInOrder + 1, inEnd, preorder , inorder);
        return root;
    }
}