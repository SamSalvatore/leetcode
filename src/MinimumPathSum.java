/**
 * @(#)MinimumPathSum.java, 7月 10, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][]dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //填充第一列
        for (int i = 1; i< m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        //填充第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        //填充第一列
        for (int i = 1; i< m; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }

        //填充第一行
        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[m-1][n-1];
    }
}