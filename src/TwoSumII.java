/**
 * @(#)TwoSumII.java, 8月 15, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author fucf
 *
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSumII {

    /**
     * 这个题目看上去是有序数组，总觉得可以用binary search来做，但是看了答案，好像高票答案都是two pointer
     * time:O(n)
     * space:O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[]res = new int[]{-1, -1};
        if (numbers == null || numbers.length < 2) {
            return res;
        }

        int start = 0;
        int end = numbers.length -1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                start++;
            }
        }

        return res;
    }


    /**
     * time:O(n)
     * space:O(n)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> value2Index = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0 ; i < numbers.length; i++) {
            int number = numbers[i];
            if (value2Index.containsKey(target - number)) {
                res[0] = i;
                res[1] = value2Index.get(target - number);
            } else {
                value2Index.put(number, i);
            }
        }

        return res;
    }
}