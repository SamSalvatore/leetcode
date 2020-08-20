/**
 * @(#)MajorityElement.java, 8月 20, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    /**
     * 摩尔投票算法
     * nums分为两个阵营 majorityNumber 数组和其他数字组成的数组
     * 两两一一消耗，最后剩下的一定是majorityNumber
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int majorityNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majorityNumber = nums[i];
            }

            if (nums[i] == majorityNumber) {
                count++;
            } else {
                count--;
            }
        }

        return majorityNumber;
    }
}