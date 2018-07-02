package beginer.list;

import org.junit.Test;

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
