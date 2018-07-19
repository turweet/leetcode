package medium.list;

import beginer.list.ListNode;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers2 {
    /**
     * 方法：
     * 用两个stack分别存储l1，l2，然后出栈相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val1 = 0;
            int val2 = 0;
            if (!stack1.isEmpty()) {
                val1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val2 = stack2.pop();
            }
            int sum = carry + val1 + val2;
            ListNode node = new ListNode(sum % 10);
            dummy.next = node;
            node.next = pre;
            pre = node;
            carry = sum / 10;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            dummy.next = node;
            node.next = pre;
        }
        return dummy.next;
    }
}
