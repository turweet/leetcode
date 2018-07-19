package cc150.list;

import beginer.list.ListNode;
import summary.Attention;
import summary.TwoPointer;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * 方法1：遍历拿到长度len，然后访问len-k即可
 */
public class FindKthToTail {
    /**
     * 用递归法实现，同样用栈也可以实现
     *
     * @param head
     * @param k
     * @return
     */
    @Attention
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        ListNode lastK = null;
        for (int i = 0; i < k; i++) {
            if (stack.isEmpty()) {
                return null;
            }
            lastK = stack.pop();
        }
        return lastK;
    }

    /**
     * 一遍遍历就好了
     *
     * 两个指针p1,p2，p2向前移动k个几点，然后p1,p2同时移动，当p2到达末尾时候，p1到达倒数第k个
     *
     * @param head
     * @param k
     * @return
     */
    @Attention
    @TwoPointer
    public ListNode FindKthToTail2(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (k > 0) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
            k--;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

}
