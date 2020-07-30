/**
 * @(#)PopulatingNextRightPointersInEachNode.java, 7月 29, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 挺重要的一道题
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
 * 举例:
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 *
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 *
 * 提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * 递归写法
     * time: O(n)
     * space:O(n)
     * @param root
     * @return
     */
    public Node connect(Node root) {
        helper(root);
        return root;
    }

    /**
     * 对于任一Node节点，都需要依次执行如下操作。因此可以使用递归来解决
     * @param root
     */
    private void helper(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        helper(root.left);
        helper(root.right);
    }


    /**
     * 迭代写法
     * time: O(n)
     * space:O(1)
     *
     * 使用二叉树的层次遍历。一层一层的将该层Node节点连接起来
     * @param root
     * @return
     */
    public Node connectIterative(Node root) {
        if (root == null) {
            return null;
        }

        Node leftBeginNode = root;
        while (leftBeginNode != null) {
            Node curLevelNode = leftBeginNode;
            while (curLevelNode != null) {
                //从左到右遍历该层所有的节点
                if(curLevelNode.left != null) {
                    curLevelNode.left.next = curLevelNode.right;
                }

                if (curLevelNode.right != null && curLevelNode.next != null) {
                    curLevelNode.right.next = curLevelNode.next.left;
                }

                curLevelNode = curLevelNode.next;
            }

            //从上到下遍历所有层级的Node节点
            leftBeginNode = leftBeginNode.left;
        }

        return root;
    }
}