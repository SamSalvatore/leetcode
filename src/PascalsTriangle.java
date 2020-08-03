/**
 * @(#)PascalsTriangle.java, 8月 02, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fucf
 *
 * 重要性：考的少
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {


    /**
     * 思路: 实现题
     * 对于每一行的数组，都比上一行多一个元素。
     * 观察元素特点可知，我们可以在每一行的开始插入1，对于除首尾外的其他元素，都可以使用公式
     * list.set(j, list.get(j) + list.get(j+1))
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1 ; i <= numRows; i++) {
            list.add(0,1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }

            res.add(new ArrayList<>(list));
        }

        return res;
    }

}