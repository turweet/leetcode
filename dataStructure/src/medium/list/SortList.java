package medium.list;

import beginer.list.ListNode;
import summary.Attention;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * <p>
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
@Attention
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null // fast slow的判断条件写错了
                && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        //下面还是要取到返回值的！
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(second);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (first != null || second != null) { //忘记给指向的指针加一
            if (first != null && second != null) {
                if (first.val > second.val) {
                    head.next = second;
                    second = second.next;
                } else {
                    head.next = first;
                    first = first.next;
                }
                head = head.next;
            }
            if (first == null && second != null) {
                head.next = second;
                head = head.next;
                second = second.next;
            }
            if (second == null && first != null) {
                head.next = first;
                head = head.next;
                first = first.next;
            }
        }
        return dummy.next;
    }
}
