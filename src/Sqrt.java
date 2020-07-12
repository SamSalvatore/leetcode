/**
 * @(#)Sqrt.java, 7月 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 * <p>
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        long low = 0;
        long high = x;
        while (low + 1 < high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
                high = (int)mid;
            } else {
                low = (int)mid;
            }
        }

        return high * high < x ? (int)high : (int)low;
    }
}