/**
 * @(#)MaximumProductSubarray.java, 8月 13, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.sun.tools.javac.tree.Pretty;

/**
 * @author fucf
 *
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 */
public class MaximumProductSubarray {

    /**
     * 参考 https://leetcode.com/problems/maximum-product-subarray/discuss/48252/Sharing-my-solution%3A-O(1)-space-O(n)-running-time
     *
     * 在i处计算最大乘积需要知道什么？回想一下我们在“最大子数组和”（Kadane算法）中所做的事情，仅已知的i-1的最大末端还不够。
     *
     * 由于负数和乘法的性质，我们需要在i-1处有max和min终止，以防i处的负数导致它们交换。因此，我们维护两个局部最优变量，并在每次迭代和全局最大值中更新它们。
     *
     * 这是我的最终解决方案。别忘了像我们在Kadane算法中所做的那样，第三个“候选”数字本身也是如此，因为如果不再存在局部最优值，我们可以抛弃它们。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFarPrev = nums[0];
        int minSoFarPrev = nums[0];
        int maxSoFar;
        int minSoFar;
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(Math.max(maxSoFarPrev * nums[i], minSoFarPrev * nums[i]), nums[i]);
            minSoFar = Math.min(Math.min(maxSoFarPrev * nums[i], minSoFarPrev * nums[i]), nums[i]);

            maxSoFarPrev = Math.max(maxSoFar, nums[i]);
            minSoFarPrev = Math.min(minSoFar, nums[i]);
            max = Math.max(max, maxSoFar);
        }

        return max;
    }
}