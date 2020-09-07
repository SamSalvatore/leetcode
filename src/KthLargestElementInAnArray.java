/**
 * @(#)KthLargestElementInAnArray.java, 8月 29, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author fucf
 *
 * 很重要的题
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class KthLargestElementInAnArray {

    //参考 https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained

    /**
     * 思路： 快排
     * time: O(nlogn)
     * space:O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    /**
     * 思路：优先队列数据结构
     * time:O(n * logK)
     * spoace:O(k)
     *
     * This is due the fact that the PriorityQueue is implemented as a Binary Heap,  which in fact is nothing more then complete binary tree.
     * So both inserting and removing the values through offer() and poll() methods have O(lg K) complexity
     * and altogether since you doing this operation N times the total complexity is O(N lg K)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        //默认为最小堆。即按照升序排列
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0 ; i < nums.length; i++) {
            queue.add(nums[i]);

            //queue中只保存较大的K个数。queue.poll()是将堆中最小的元素去除
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

    /**
     * 思路3: 快排. 相比于Arrays.sort 不需要将整个数组排序
     * time: best:O(N) / worse O(N2)
     * space:O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        int start = 0;
        int end = nums.length;
        while (start <= end) {
            int divisionIndex = partition(nums, start, end);
            if (divisionIndex == k - 1) {
                break;
            } else if (divisionIndex < k - 1) {
                start = divisionIndex + 1;
            } else {
                end = divisionIndex - 1;
            }
        }

        return nums[nums.length - k];
    }

    //排序，较大的数字在左边。 如 nums = [8,3,10,7,6,9,5] pivot = 8， 排序后的nums = [10,9,8,3,6,7,5]
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int l = start + 1;
        int r = end;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l, r);
                l++;
                r--;
            }

            if (nums[l] >= pivot) {
                l++;
            }

            if (nums[r] <= pivot) {
                r--;
            }
        }

        swap(nums, start, r);
        return r;
    }



    private void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}