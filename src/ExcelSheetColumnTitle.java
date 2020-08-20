/**
 * @(#)ExcelSheetColumnTitle.java, 8月 20, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 */
public class ExcelSheetColumnTitle {

    /**
     * Instead of 1 -> A, 26 -> Z, we can assume that 0 -> A, 25 -> Z,
     * and then here comes the base 26 representation,
     * it's similar when you convert a number from base 10 to base 2
     *
     * 需要注意的是每次都需要向前追加字符
     * sb.insert(0, (char) ((n % 26) + 'A'));
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0, (char) ((n % 26) + 'A'));
            n = n / 26;
        }

        return sb.toString();
    }
}