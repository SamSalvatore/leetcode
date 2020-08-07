/**
 * @(#)SumRootToLeafNumbers.java, 8月 06, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class SumRootToLeafNumbers {

    /**
     * 思路: 前序遍历
     *
     * 我们之前做过前序遍历的题，只是当时得到的是不同的路径集合[1,2]和[1,3]
     * 现在相当于对于某一个集合，我们要算出集合的值。
     *
     * @param root
     * @return
     */

    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root ,0);
        return res;
    }

    //sum 代表某个path的和
    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        //举个例子，原来是res.add(new ArrayList<>(list)) 现在改为 res + = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += sum *10 + root.val;
        }

        //举个例子 原来是将2添加到[1], 现在改为更新sum = 1 * 10 + 2
        helper(root.left, sum * 10 + root.val);
        helper(root.right, sum * 10 + root.val);
    }
}