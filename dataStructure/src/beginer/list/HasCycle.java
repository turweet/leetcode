package beginer.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：
 * 1. 一个快指针f，一个慢指针s，总是相差1，当f的next为s的时候就是有环
 * 2. 参考的答案使用倍速的指针，总会相遇，一开始总是考虑的是差1的指针，这样是不会相遇的
 *
 * 第2中情况下的时间复杂度分析值得注意，需要好好看看!!!
 */
public class HasCycle {
    public boolean hasCycle_byHashSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
