package medium.list;

import beginer.list.ListNode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int one = p == null ? 0 : p.val;
            int two = q == null ? 0 : q.val;
            int newVal = one + two + carry;
            carry = newVal / 10;
            ListNode node = new ListNode(newVal % 10);
            current.next = node;
            current = current.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry == 1) {
            current.next = new ListNode(1);
        }
        return dummy.next;
    }
}
