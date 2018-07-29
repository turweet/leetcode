package beginer.list;

/**
 * Write a program to find the node at which the intersection of two
 * singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * <p>
 * begin to intersect at node c1.
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 *
 * times:1
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        int lenA = 0;
        int lenB = 0;
        while (pa != null) {
            lenA++;
            pa = pa.next;
        }
        while (pb != null) {
            lenB++;
            pb = pb.next;
        }
        if (lenA == 0 || lenB == 0) {
            return null;
        }
        pa = headA;
        pb = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                pa = pa.next;
            }
        } else if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                pb = pb.next;
            }
        }
        while (pa != null) {
            if (pa.val == pb.val) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }
}
