/**
 * @(#)ContainsDuplicateII.java, 9月 07, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author fucf
 *
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsDuplicateII {

    /**
     * Iterate through array and use HashMap to save number[i] as key and i as value.
     * If the map already contains number[i] -
     * subtract map.get(number[i]) from i and
     * return true if result is less than or equal to k.
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> value2Index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (value2Index.containsKey(nums[i]) && i - value2Index.get(nums[i]) <= k) {
                return true;
            }

            value2Index.put(nums[i], i);
        }

        return false;
    }

}