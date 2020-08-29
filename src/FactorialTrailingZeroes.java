/**
 * @(#)FactorialTrailingZeroes.java, 8月 20, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 * <p>
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class FactorialTrailingZeroes {

    /**
     * 参考 https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52371/My-one-line-solutions-in-3-languages
     * https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52373/Simple-CC%2B%2B-Solution-(with-detailed-explaination)
     *
     * I think the key idea is count how many 5's are in the factorial.
     * So first we add n/5.
     * Wait, we are missing 5X5, 2X5X5..., so we add n/25 (why not count as two 5's for each , because one is already counted in n/5).
     * Wait, we are missing 5X5X5, 2X5X5X5..., so we add n/125.
     * Thus, count = n/5 + n/25 + n/125 + ... + 0
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}