/**
 * @(#)UniquePaths.java, 7月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 * LC62
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            //第一行全部赋予1
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //dp[j]: 代表当遍历到第i行时，第j列的值 = 遍历到i行时，第j-1列的值(dp[j-1]) + 第i-1行，第j列的值(dp[j])
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    //Cm+n-2, m-1
    public int uniquePaths3(int m, int n) {
        double res = 1;
        for (int i = 1; i <= n - 1; i++) {
            res = res * (i + m - 1) / i;
        }

        return (int) res;
    }
}