package beginer.list;

import org.junit.Test;

/**
 * 思路：
 * 1. 第一个想到的方法是把结点的值都放入数组中，从头尾同时开始遍历数组非常方便了
 * 2. 第二个想到的方法是创建一个逆序的结点list，然后同时遍历正序和逆序的到最后还相等的话就没问题
 * 3. 参考了别人的做法，他没有额外的空间来存储全部结点，但仍需要遍历一遍,不让他的slow fast指针不错！
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    @Test
    public void test() {
        int[] array = {1,2,3,4,5};
        ListNode node = ListNode.create(array);
        isPalindrome(node);
        ListNode.printList(node);
    }
}
