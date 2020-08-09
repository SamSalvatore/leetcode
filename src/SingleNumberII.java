/**
 * @(#)SingleNumberII.java, 8月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 不是很重要
 * 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class SingleNumberII {
    /**
     * 参考:https://leetcode.com/problems/single-number-ii/discuss/43297/Java-O(n)-easy-to-understand-solution-easily-extended-to-any-times-of-occurance
     * https://leetcode-cn.com/problems/single-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--31/
     *
     * 将nums[i] 用二进制表示。则对于每一列，如果该列 1 出现的次数不为3的倍数，则说明多余的那个1为SingleNumber中的1。
     * 如何找到singNumber的这个1呢: sum % 3 (sum为该列1的和, 3为题中其他元素出现的次数)
     * 假设当前位为i，则该列的1对应的值为1<<i
     *
     * 我们最后将每一列的 1<<i 求和即可
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int currentBitSum = 0; //当前列1的和
            for (int j = 0; j < nums.length; j++) {
                //((nums[i] >> j) & 1)  为nums[j] 第i位的值。 i从右往左数
                currentBitSum = currentBitSum + ((nums[j] >> i) & 1);
            }

            if (currentBitSum % 3 != 0) { //说明当前列存在多余的1
                result += (1 << i);
            }
        }

        return result;
    }
}