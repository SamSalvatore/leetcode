/**
 * @(#)MinimumDepthOfBinaryTree.java, 7月 26, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class MinimumDepthOfBinaryTree {

    /**
     * 错误解法 ！！！
     *      1
     *     /
     *    2
     * 错误原因:对于 1->2 这样的树，我们的代码逻辑会输出结果1。因为我们误认为1的右子树高度为0。
     *
     * 这里我自己范了两个错误。第一个是对叶子结点的定义理解错了:
     * 叶子节点是指没有子节点的节点。对于题中举的例子。叶子结点有:9,15,7.
     * 按照我们的错误解法，会将1的右子树null也算做叶子结点。并计算出高度为1。这里就出错了
     * @param root
     * @return
     */
    public int 错误解法(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.min(错误解法(root.left), 错误解法(root.right)) + 1;
    }


    /**
     * 参考 https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution
     *
     *  Key point:
     *  if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
     *  if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return Math.max(left, right) + 1;
        }

        return Math.min(left, right) + 1;
    }

}