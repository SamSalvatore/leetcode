/**
 * @(#)ConstructBinaryTreeFromInorderAndPostorderTraversal.java, 7月 23, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author fucf
 *
 * 比较难，可以不深究
 *
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     *  * 中序遍历 inorder = [9,3,15,20,7]
     *                      l r   > r <
     *  * 后序遍历 postorder = [9,15,7,20,3]
     *                          l + r   r
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, inorder.length -1, postorder.length  -1 , inorder, postorder);
    }

    //postEnd(preStart) 代表root根节点的位置。
    private TreeNode helper(int inStart, int inEnd, int postEnd, int[] inorder, int[] postorder) {
        if (inStart > inEnd || postEnd > postorder.length - 1) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndexInInOrder = 0;
        for (int i = inStart ; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndexInInOrder = i;
                break;
            }
        }

//        错误逻辑
//        左子树的postEnd 在postOrder的l+r中间，需要计算
//         左子树的终止位置- 左子树的起始位置 = (rootIndex - 1 ) - inStart = x - 0;
        //不能通过计算左子树的逻辑来算newPostEnd的原因是，我们认为了postStart 一定是0，而这是不对的。

        //正确逻辑
        //右子树的postStart - 1 就是左子树的postEnd
        //右子树的终止位置 - 右子树的开始位置 = （postEnd-1） - postStart = intEnd - (rootIndex  + 1 )
        // x = postStart - 1 = postEnd - intEnd + rootIndex - 1
        root.left = helper(inStart, rootIndexInInOrder - 1, postEnd - inEnd + rootIndexInInOrder - 1, inorder, postorder);
        root.right = helper(rootIndexInInOrder + 1, inEnd, postEnd - 1, inorder, postorder);

        return root;
    }
}