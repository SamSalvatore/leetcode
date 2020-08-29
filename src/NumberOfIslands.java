/**
 * @(#)NumberOfIslands.java, 8月 27, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 非常重要的题
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 */
public class NumberOfIslands {

    int rowSize;
    int colSize;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        rowSize = grid.length;
        colSize = grid[0].length;
        int landNumber = 0;
        for (int i = 0 ; i < rowSize; i++) {
            for (int j = 0 ; j < colSize; j++) {
                //如果当前区域为'1',则遍历其上下左右 置为0
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    landNumber++;
                }
            }
        }

        return landNumber;
    }

    /**
     * 如果grid[i][j] = '1', 则需要上下左右都将遍历到的'1'置为0
     *
     * 00100
     * 01101
     * 00111
     * @param grid
     * @param i
     * @param j
     */
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= rowSize || j < 0 || j >= colSize || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}