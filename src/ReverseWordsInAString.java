/**
 * @(#)ReverseWordsInAString.java, 8月 13, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class ReverseWordsInAString {

    /**
     * 参考 https://leetcode.com/problems/reverse-words-in-a-string/discuss/47706/My-accepted-Java-solution
     * "\s" is a regex class for any kind of whitespace (space, tab, newline, etc).
     * Since Java uses "\" as an escape character in strings (e.g. for newlines: "\n"),
     * we need to escape the escape character ;-) So it becomes "\\s". The "+" means one or more of them.
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] parts = s.split("\\s+");
        String out = "";
        for (int i = parts.length - 1 ; i >= 0; i--) {
            out += parts[i] + " ";
        }

        return out.trim();
    }
}