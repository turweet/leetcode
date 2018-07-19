package cc150.list;

import beginer.list.ListNode;
import summary.TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class RemoveRepeatNode {
    public ListNode removeRepeat1(ListNode listNode) {
        Set<Integer> set = new HashSet<>();
        ListNode curr = listNode;
        ListNode pre = null;
        while (curr != null) {
            if (set.contains(curr.val)) {
                pre.next = curr.next;
            } else {
                set.add(curr.val);
                pre = curr;
            }
            curr = curr.next;
        }
        return listNode;
    }

//attention

    /**
     * 不借助外部的空间，使用双指针法，但是时间复杂度是平方级别的
     *
     * @param listNode
     * @return
     */
    @TwoPointer
    public ListNode removeRepeat(ListNode listNode) {
        ListNode curr = listNode;
        while (curr != null) {
            ListNode temp = curr.next;
            ListNode pre = curr;
            while (temp != null) {
                if (temp.val == curr.val) {
                    pre.next = temp.next;
                } else {
                    pre = temp;
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }
        return listNode;
    }
}
