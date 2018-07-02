package beginer.list;

import org.junit.Test;

/**
 * 原题：
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * <p>
 * <p>
 * way1：
 * 获取到长度-》把值都放到数组里边-》倒序遍历数组放到新的链表中返回
 * way2:
 * 使用双指针法，linkedlist还是很奇特的，利用next指针，中间值最后神奇的完成了任务
 */
public class ReverseList {
    public ListNode reverseList_firstComeout(ListNode head) {
        ListNode list = head;
        int len = 0;
        while (list != null) {
            len++;
            list = list.next;
        }
        int[] listNodes = new int[len];
        list = head;
        int i = 0;
        while (list != null) {
            listNodes[i] = list.val;
            i++;
            list = list.next;
        }
        ListNode result = new ListNode(-1);
        list = result;
        for (int j = 0; j < listNodes.length; j++) {
            list.next = new ListNode(listNodes[listNodes.length - j - 1]); //循环内有i, 但是在j里边很容易就引用到i了，这个要注意
            list = list.next;
        }
        return result.next;
    }

    public ListNode reverseList_1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;
        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        return current;
    }


    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    /**
     * 递归法很牛逼，但是很难想出来
     * @param head
     * @return
     */
    public ListNode reverseList_Recursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList_Recursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode result = reverseList(node);
        System.out.println(result.val);
    }
}
