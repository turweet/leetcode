package cc150.list;

import beginer.list.ListNode;
import summary.Attention;

/**
 * 题目描述
 * <p>
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * <p>
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Partition {
    @Attention("直接使用额外的两个链表，存储比x小的和比他大的 然后再合并，因为没有说不能使用额外的空间，可以使用额外的链表空间啊！")
    public ListNode partition(ListNode pHead, int x) {
        ListNode small = new ListNode(0);
        ListNode smallCur = small;
        ListNode big = new ListNode(0);
        ListNode bigCur = big;
        while (pHead != null) {
            if (pHead.val < x) {
                smallCur.next = new ListNode(pHead.val);
                smallCur = smallCur.next;
            } else {
                bigCur.next = new ListNode(pHead.val);
                bigCur = bigCur.next;
            }
            pHead = pHead.next;
        }
        smallCur.next = big.next;
        return small.next;
    }
}
