/**
 * @(#)CopyListWithRandomPointer.java, 8月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fucf
 *
 * 138. 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 */
public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 参考https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43488/Java-O(n)-solution
     *
     * 深拷贝过程中可以很方便的记录下next节指针，但是不太方便记录random指针
     * 可以使用map遍历两遍数组。第一次遍历保存Node节点，第二次遍历对Node节点进行连接
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> nodeMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            nodeMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            nodeMap.get(cur).next = nodeMap.get(cur.next);
            nodeMap.get(cur).random = nodeMap.get(cur.random);
            cur = cur.next;
        }

        return nodeMap.get(head);
    }

    /**
     * 法二: 空间上省去了HashMap，但是需要遍历三次
     * https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
     *
     *  The idea is to associate the original node with its copy node in a single linked list. In this way, we don't need extra space to keep track of the new nodes.
     *
     * The algorithm is composed of the follow three steps which are also 3 iteration rounds.
     *
     * 1. Iterate the original list and duplicate each node. The duplicate of each node follows its original immediately.
     * 2. Iterate the new list and assign the random pointer for each duplicated node.
     * Restore the original list and extract the duplicated nodes.
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            Node tempNode = cur.next;
            Node next = new Node(cur.val);
            cur.next = next;
            next.next = tempNode;
            cur = tempNode;
        }

        cur = head;
        while (cur != null && cur.next != null ) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        cur = head;
        Node copyHead = head.next;
        Node copyIter = copyHead;

        while (cur != null) {
            Node next = cur.next.next;
            Node copyNext = next == null ? null : next.next;

            cur.next = next;
            copyIter.next = copyNext;

            copyIter = copyIter.next;
            cur = cur.next;
        }

        return copyHead;
    }
}


