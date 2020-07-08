/**
 * @(#)UniquePathsII.java, 7月 09, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] != 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] != 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    //dp[j]代表扫描当前行时，第j列的值。其实就是dp[i][j]。 只不过我们只记录当前行第j列的值
                    dp[j] = 0;
                } else if (j > 0){
                    dp[j] += dp[j -1];
                }
            }
        }

        return dp[n-1];
    }
}