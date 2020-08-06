/**
 * @(#)Triangle.java, 8月 03, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.List;

/**
 * @author fucf
 *
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Triangle {

    /**
     * 参考 https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle
     *
     * 很明显对于中间的任一一个节点。到达该节点的路径有很多条，但是我们只需要关心、记录下该节点位置的path最小值即可。
     * 对于这类问题，一般都是可以使用dp的思想来做，即空间换时间
     *
     * 可采用从上往下也可以采用从下往上。
     * @param triangle
     * @return
     */
    public int minimumTotalFromBottomToUp(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        //dp[i]: 代表某一层第i个元素的路径和的最小值
        //数组的长度之所以用triangle.size() + 1 是因为这样就不需要for循环给初始值赋值
        // dp[i] = triangle.get(triangle.size() -1).get(i);
        //之所以用triangle.size()是因为triangle.size() = triangle.get(i).size()
        int[]dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0 ; i--) {
            List<Integer> oneRowCols = triangle.get(i);
            for (int j = 0; j <= oneRowCols.size() - 1; j++) {
                dp[j] = oneRowCols.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    /**
     * 从上往下找，需要考虑的corn case会多一点
     * @param triangle
     * @return
     */
    public int minimumTotalFromUp2Bottom(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        //dp[i]: 代表某一层第i个元素的路径和的最小值
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> oneRowCells = triangle.get(i);
            //很重要！！！ 只能从右向左遍历。否则该层的dp[i]会覆盖掉上层的dp[i].影响到后面元素的计算
            for (int j = oneRowCells.size() - 1; j >= 0; j--) {
                if (j == 0) { //corn case
                    dp[j] = dp[j] + oneRowCells.get(j);
                } else if (j == oneRowCells.size() - 1) {
                    dp[j] = oneRowCells.get(j) + dp[j - 1];
                } else {
                    dp[j] = oneRowCells.get(j) + Math.min(dp[j], dp[j - 1]);
                }
            }
        }


        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            res = Math.min(res, dp[i]);
        }

        return res;
    }
}