package beginer.list;

import org.junit.Test;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

 现有一个链表 -- head = [4,5,1,9]，它可以表示为:

 4 -> 5 -> 1 -> 9

 示例 1:

 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

 示例 2:

 输入: head = [4,5,1,9], node = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

 说明:

 链表至少包含两个节点。
 链表中所有节点的值都是唯一的。
 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 不要从你的函数中返回任何结果。


 */
public class RemoveNthFromEnd_attention {
    public ListNode removeNthFromEnd_firstComeOut(ListNode head, int n) {
        if (head == null) {
            throw new IllegalArgumentException();
        }
        if (head.next == null) {
            return null;
        }
        int len = 0;
        ListNode list = head;
        while (list != null) {
            len++;
            list = list.next;
        }
        if (len == n) {
            return head.next;
        }
        list = head;
        for (int i = 1; i < len - n; i++) {
            list = list.next;
        }
        list.next = list.next.next;
        return head;
    }
    public ListNode removeNthFromEnd_simpleTwoPass(ListNode head, int n) {
        if (head == null) {
            throw new IllegalArgumentException();
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode list = head;
        while (list != null) {
            len++;
            list = list.next;
        }
        list = dummy;
        for (int i = 0; i < len - n; i++) {
            list = list.next;
        }
        list.next = list.next.next;
        return dummy.next;
        //注意这里只能返回dummy.next而不能返回head ,这样针对只有一个元素的list会实效
        //因为你只是把list的next指给null了，而head却没有变，这里很蹊跷，需要倍加注意
    }


//    public ListNode removeNthFromEnd(ListNode head, int n) {
//
//    }




    @Test
    public void test() {
//        removeNthFromEnd(new ListNode(1), 1);
    }
}
//总结:
//看着不难的一个题，结果在控制指针的时候耗费了很长时间，还有就是解法并不通用，
//对于长度为1和移除第一个的时候还要特殊照顾
