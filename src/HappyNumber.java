/**
 * @(#)HappyNumber.java, 8月 27, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author fucf
 *
 * 不是很重要
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int squareNumber = 0 ;
        int remainder = 0;
        while (set.add(n)) {
            //需要注意每次循环需要重置squareNumber
            squareNumber = 0;
            while (n > 0) {
                remainder = n % 10;
                squareNumber += remainder * remainder;
                n /= 10;
            }

            if (squareNumber == 1) {
                return true;
            }

            n = squareNumber;
        }

        return false;
    }
}