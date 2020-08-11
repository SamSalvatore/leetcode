/**
 * @(#)ACodeTemplate.java, 8月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author fucf
 *
 * 记录刷题过程中的模版
 */
public class ACodeTemplate {


    /**
     * 判断字符串是否是回文形式
     * @param string
     * @return
     */
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

    /**
     * 二分搜索
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    /**
     * 判断链表是否存在环
     *
     * 1. Use two pointers, walker and runner.
     * 2. walker moves step by step. runner moves two steps at time.
     * 3. if the Linked List has a cycle walker and runner will meet at some point.
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while(runner!=null && runner.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) {
                return true;
            }
        }
        return false;
    }


    /**
     * 寻找链表的入口节点
     * 参考 https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
     *
     * 这道题就是简单的推导实现题。假设慢指针和快指针在相遇时，慢指针所走路径为s,则快指针所走路径为2s
     * 假设环的长为b。链表开始处到环的入口举例为a
     *
     * 则：
     * 2s - s = n * b (快指针比慢指针多走n个环的长度)  => s = nb
     * 即慢指针此时在走a的长度就可以到达环的入口
     *
     * 如何控制慢指针在走a的长度？
     * 快指针重新回到链表入口改为和慢指针相同的速度前进。则快,慢指针将会在环的入口相遇，所走距离刚好为a
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }


        //There is no cycle in LinkedList
        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }


        return fast;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    //二叉树的前序遍历
    /**
     * 二叉树的前序遍历迭代版本
     *
     * 二叉树的前｜中｜后 迭代版本参见
     * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
     * Input: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * Output: [1,2,3]
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) { //stack特点:后进先出，所以后进左孩子。这样的话可以先打印左孩子
                stack.push(current.left);
            }
        }
        return list;
    }

    /**
     * 二叉树的前序遍历 - 递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> pre = new LinkedList<>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null) {
            return;
        }
        pre.add(root.val);
        preHelper(root.left, pre);
        preHelper(root.right, pre);
    }

    //二叉树的后序遍历
    /**
     * 二叉树的后序遍历迭代版本
     * 前序遍历 中 -> 左 -> 右
     *  => 中 -> 右 -> 左 stack后压入右孩子(后进先出)
     *  => reverse (list.addFist)
     *
     * 后续遍历 左 -> 右 -> 中
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
            if (cur.left != null) {
                stack.push(cur.left);

            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        return res;
    }


    /**
     * 二叉树的后序遍历 递归版本
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        postHelper(res, root);
        return res;
    }

    private void postHelper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        postHelper(res, root.left);
        postHelper(res, root.right);
        res.add(root.val);
    }


    //TODO 二叉树的前序、中序、后序遍历
    //TODO 数字的相加
    //TODO backTracking
    //TODO 排列


}