/**
 * @(#)PalindromePartitioning.java, 8月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author fucf
 *
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {

    /**
     * 参考 https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java%3A-Backtracking-solution.
     *
     * 解题思路:
     * 固定S的前i个元素，如果前i个元素是回文字符串，则需要计算s.subString(i, s.length() -1) 回文字符串的集合。
     * 计算s.subString(i, s.length() -1) 回文字符串的集合和上面先固定i个元素的方法一摸一样。因此，本题可使用backTracking方法来做
     * @param s
     * @return
     */
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }


        backTracking(new ArrayList<>(), s, 0);
        return res;
    }

    private void backTracking(List<String> list, String s, int startPosition) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0 ; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                backTracking(list, s.substring(i + 1), i +1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }

        for (int i = 0 ; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1- i)) {
                return false;
            }
        }

        return true;
    }

}