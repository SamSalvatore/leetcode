/**
 * @(#)CombinationSumIII.java, 8月 29, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author fucf
 *
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {

    /**
     * 注意点：
     * 1. 三步走: choose, explore, unchoose
     * 2. 注意explore过程i 从 start 开始
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(new ArrayList<>(), k , n, 1);
        return res;
    }


    private void backTracking(List<Integer> list, int k, int n, int start) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            //choose
            list.add(i);

            //explore
            backTracking(list, k, n - i, i + 1);

            //unchoose
            list.remove(list.size() - 1);
        }
    }
}