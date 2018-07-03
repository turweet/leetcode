package beginer.list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode create(int[] array) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            dummy.next = node;
            dummy = node;
        }
        return head.next;
    }

    public static void printList(ListNode node) {
        if (node == null) {
            System.out.println("node is null");
            return;
        }
        System.out.println();
        ListNode dummy = node;
        while (dummy != null) {
            System.out.printf(dummy.val + "->");
            dummy = dummy.next;
        }
        System.out.println();
    }
}

