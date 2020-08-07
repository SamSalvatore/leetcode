/**
 * @(#)SurroundedRegions.java, 8月 07, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * DFS经典题目
 *
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class SurroundedRegions {

    /**
     * 参考:https://leetcode.com/problems/surrounded-regions/discuss/41612/A-really-simple-and-readable-C%2B%2B-solutionuff0conly-cost-12ms
     *
     * 我一开始想简单了， 感觉这不就是遍历一遍二维数组。如果上下左右都是X，就把O替换为X，否则do nothing。
     * 但是很快就被几个case否决掉了。即使某个O周围都是O，但是如果再外层是X的话，那也是要被替换的。
     *
     * 本题的解法是: 从矩阵的边界入手，边界上的O一定是不能包围的。然后从边界上的O依次往周围搜索。
     * 找到所有与边界O相连的节点。最终将这些节点的状态记录下来，其余的节点全部变为X
     *
     * time:O(m * n)
     * space: O(n) 栈空间
     * @param board
     *
     * 注: BFS 和 DFS 的区别
     * https://cuijiahua.com/blog/2018/01/alogrithm_10.html#:~:text=BFS%20%E5%B8%B8%E7%94%A8%E4%BA%8E%E6%89%BE%E5%8D%95%E4%B8%80,%E6%9E%9D%E7%9A%84%E6%A6%82%E5%BF%B5%E8%AF%B7%E7%99%BE%E5%BA%A6%EF%BC%89%E3%80%82
     *
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        int rowSize = board.length;
        int colSize = board[0].length;

        //找到第0行&最后一行边界上面的'O'
        for (int col = 0 ; col < colSize; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }

            if (board[rowSize - 1][col] == 'O') {
                dfs(board, rowSize - 1, col);
            }
        }

        //找到第0列&最后一列边界上面的'O'
        for (int row = 0 ; row < rowSize; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }

            if (board[row][colSize - 1] == 'O') {
                dfs(board, row, colSize - 1);
            }
        }

        for (int i = 0 ; i < rowSize; i++) {
            for (int j = 0; j <colSize; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                board[row][col] != 'O') { //保证board[row][col]一定是和边界O相连的O
            return;
        }

        board[row][col] = '1';
        //将'O' 相连的'O'也替换为'1'
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}

