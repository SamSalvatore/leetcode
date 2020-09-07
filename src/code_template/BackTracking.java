/**
 * @(#)BackTracking.java, 9月 07, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package code_template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fucf
 */
public class BackTracking {

    /**
     * 回溯问题，细节很多，但是也有一点套路：
     * 1、先画出递归树，帮助分析；
     * 2、然后使用深度优先遍历，搜索可能的解；
     * 3、注意状态重置（恢复现场，以免出错）和剪枝（避免不必要的搜索消耗时间）。
     * 画图帮助分析，看清剪枝和结算的条件
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/combination-sum-iii/solution/hui-su-jian-zhi-by-liweiwei1419/
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        // Backtracking
        // Edge case
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> step = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, step, result);
        return result;
    }
    public void helper(int[] nums, int start, List<Integer> step, List<List<Integer>> result) {
        result.add(new ArrayList<>(step));
        for(int i = start; i < nums.length; i++) { //注意这里的i是从start开始
            // choose
            step.add(nums[i]);
            // explore
            helper(nums, i + 1, step, result);
            // unchoose
            step.remove(step.size() - 1);
        }
    }
}