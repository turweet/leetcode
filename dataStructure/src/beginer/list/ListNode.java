package beginer.list;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
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

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
}

