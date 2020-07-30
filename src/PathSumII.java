/**
 * @(#)PathSumII.java, 7月 29, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fucf
 *
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * backTracking的经典题目
     * 需要注意两点:
     * 1. 在递归过程中list传递的是引用。我们需要执行的是res.add(new ArrayList<>(list));
     * 2. 每次执行完当前选择之后需要最后撤销选择list.remove(list.size() - 1);
     *
     *
     * 参考：https://leetcode.com/problems/path-sum-ii/discuss/36683/DFS-with-one-LinkedList-accepted-java-solution
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }

        helper(root, sum, new ArrayList<>());
        return res;
    }

    /**
     * Question：why do we need this line of code: result.add(new LinkedList(currentResult));
     *
     * Answer:when you use add function of List, it just add a copy of reference of the object into the List
     * instead of a new copy of the object.
     * So if you don't create a new copy, all the reference you add to your result refer to the same object.
     *
     * Question：why do we need this line of code : cur.remove(cur.size()-1);?
     * A:This is the backtracking point.
     * If we execute two sub recursive code in else branch and still can't get a match pathSum,
     * this means the current "root" which already added into the List currentResult can not lead us to the correct answer.
     * So we need to remove it from List currentResult and try other possible branches,
     * this is what backtracking means.
     * @param root
     * @param sum
     * @param list
     */
    private void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(list));
            }
        }

        helper(root.left, sum - root.val, list);
        helper(root.right, sum - root.val, list);
        list.remove(list.size() - 1);
    }
}

