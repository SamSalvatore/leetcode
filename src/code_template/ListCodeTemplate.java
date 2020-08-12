/**
 * @(#)ListCodeTemplate.java, 8月 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package code_template;

/**
 * @author fucf
 */
public class ListCodeTemplate {

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

    /**
     * 合并链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return dummy.next;
    }

    /**
     * 寻找链表的中间节点
     *
     * 需要注意如果需要在中间分隔链表，则需要执行
     * ListNode middleNode = findMiddleNode(head);
     * ListNode secondHalfStartNode = middleNode.next;
     * middleNode.next = null;
     * @param head
     * @return
     */
    private ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}