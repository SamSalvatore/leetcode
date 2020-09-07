/**
 * @(#)MaximalSquare.java, 9月 03, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class MaximalSquare {

    /**
     * 大的正方形的边长的解可以由小正方形的边长的解得到，因此可以考虑用动态规划来做
     *
     * dp[i + 1][j + 1]:代表matrix[i][j]为右下角的可以拼成的最大正方形的边长
     * 初始值: dp数组初始值全部为0
     * 状态转移方程: dp[i+1][j+1] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i][j-1])) + 1;
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        //dp[i+1][j+1] 代表以matrix[i][j]为右下角的正方形的边长
        int[][]dp = new int[rowSize + 1][colSize + 1];
        int res = 0;
        for (int i = 1 ; i <= rowSize; i++) {
            for (int j = 1 ; j <= colSize; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                   dp[i][j] = Math.min(dp[i-1][j -1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }
}