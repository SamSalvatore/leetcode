/**
 * @(#)Candy.java, 8月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;

/**
 * @author fucf
 *
 * 简单实现题
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 *
 * 示例2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Candy {

    /**
     * 参考 https://leetcode.com/problems/candy/discuss/42774/Very-Simple-Java-Solution-with-detail-explanation
     *
     * We take ratings array as [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
     * In the given problem each student will have at least 1 candy. So distribute 1 candy to each.
     *
     * ratings:     [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
     * candies:     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
     * Now traverse the array from left to right. If the rating of (n+1) child is greater than (n) child then set the candy of (n+1) child as one candy more than the (n) child candies.
     *
     * ratings:     [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
     * candies:     [1, 2, 1, 1, 2, 3, 4, 1, 1, 1, 2, 1]
     * Now traverse the array from right to left. If the (n) child rating is more than (n+1) child and (n) child candies is less than one more than (n+1) child candies then update the candies of (n) child as 1+ (n+1) candies.
     *
     * ratings:     [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
     * candies:     [1, 2, 1, 1, 2, 3, 4, 3, 2, 1, 2, 1]
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }

        int[]candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) { // Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) { // Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1] ) {
                candies[i] = candies[i+1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0 ; i < candies.length; i++) {
            sum += candies[i];
        }

        return sum;
    }
}