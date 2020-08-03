/**
 * @(#)PopulatingNextRightPointersInEachNodeII.java, 7月 29, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class PopulatingNextRightPointersInEachNodeII {

    /**
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/472675/Short-Java-solution-with-explanation-100-runtime-and-100-memory
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNext(root.next);
            }
        }

        if (root.right != null) {
            root.right.next = findNext(root.next);
        }

        findNext(root.right);
        findNext(root.left);
        return root;
    }


    /**
     * scan all next parent nodes until we find the first left or right child
     * 因为会存在next节点的left|right 无孩子节点的情况，这个时候需要继续遍历next节点
     * @param root
     * @return
     */
    private Node findNext(Node root) {
        if (root == null) {
            return null;
        }

        while (root != null) {
            if(root.left != null) {
                return root.left; //stop if encounter nonNull child Node
            }

            if (root.right != null) {
                return root.right;
            }

            root = root.next;
        }

        return null;
    }
}