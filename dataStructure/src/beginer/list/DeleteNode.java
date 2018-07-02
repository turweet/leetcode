package beginer.list;

import org.junit.Test;

public class DeleteNode {

    private ListNode head = createListNode();

    public void deleteNode_firstComeOut(ListNode node) {
        ListNode listNode = head;
        ListNode parent = null;
        while (listNode != null) {
            if (listNode.val == node.val) {
                if (parent == null) {
                    head = head.next;
                    return;
                } else {
                    parent.next = listNode.next;
                    return;
                }
            }
            parent = listNode;
            listNode = listNode.next;
        }
    }

    private ListNode createListNode() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        return listNode;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    @Test
    public void test() {
        deleteNode_firstComeOut(new ListNode(5));
        System.out.println(head.next.val);
    }
}
