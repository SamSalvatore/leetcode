/**
 * @(#)FindMinimumInRotatedSortedArrayII.java, 8月 14, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 154. 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 示例 1：
 *
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 *
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 *
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 */
public class FindMinimumInRotatedSortedArrayII {

    /**
     * 参考https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-de-zui--16/
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length -1;
        while (start + 1 < end) {
            if (nums[start] < nums[end]) { //如果nums[start] < nums[end] 则在[start,end]一定是单调递增
                return nums[start];
            }

            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) { //mid落在旋转数组部分
                end = mid;
            } else if (nums[mid] > nums[end]) { ///mid落在未旋转数组部分
                start = mid;
            } else { //可能在未旋转部分，也可能在旋转部分 22222122, 2122222
                end--;
            }
        }

        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}