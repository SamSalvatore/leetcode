/**
 * @(#)UniqueBinarySearchTrees.java, 7月 21, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 * <p>
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBinarySearchTrees {

    /**
     * 思路: 大问题的解是由多个子问题的解组成的，因此该题可使用动态规划(DP)来解决
     * <p>
     * 假设某个子树有n个节点。根据二叉搜索树的特点则该子树的总路径数F(n) 只和n的个数有关，和n的具体数值无关
     * 假设节点个数为n，root节点val = i。则这种情况下的总路径和为
     * dp[i] = dp[i - 1] * dp[n - i] (左子树个数 + 右子树个数 + 1 = n) 另外需要注意的是，是乘的关系，而不是加的关系。
     * 因为左子树的任意一种情况都和右子树是互斥的
     * <p>
     * sum = dp[1] + dp[2] + ... + dp[n]
     * = dp[0] * dp[n - 1] + dp[1] * dp[n-2] + ... + dp[n -1] * dp[0]
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        //dp[0]代表输入整数为0，此时只有一棵root.val = 0的树
        //也可以根据下面的dp计算公式理解。dp[0]代表无左子树或者右子树的情况
        dp[0] = 1;

        for (int totalNode = 0; totalNode <= n; totalNode++) { //totalNodeNum代表总节点的个数
            for (int leftNode= 1; leftNode <= totalNode; leftNode++) { //注意: leftNode代表左孩子 + 根节点的的个数
                dp[totalNode] += dp[leftNode - 1 ] * dp[totalNode - leftNode]; //注意需要考虑根节点的个数
            }

//            for (int leftNode= 0; leftNode <= totalNode - 1; leftNode++) { //注意: leftNode代表左孩子（不包括根节点的的个数）
//                dp[totalNode] += dp[leftNode] * dp[totalNode - leftNode - 1 ]; //注意需要考虑根节点的个数
//            }
        }

        return dp[n];
    }
}