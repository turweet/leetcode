package medium.list;

import beginer.list.ListNode;
import summary.Attention;
import summary.TwoPointer;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class DetectCycle {
    @Attention("这里的set里边只能装ListNode，而不是Integer，因为数字可能重复，但是对象不会重复！！！")
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 讲解：https://leetcode.com/problems/linked-list-cycle-ii/discuss/44777/Concise-JAVA-solution-based-on-slow-fast-pointers
     * @param head
     * @return
     */
    @TwoPointer
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
