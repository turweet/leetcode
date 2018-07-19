package cc150.list;

import beginer.list.ListNode;
import summary.Attention;

/**
 * 题目描述
 * <p>
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * <p>
 * 给定待删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 */
public class RemoveNode {
    @Attention("1. 需要与面试官讨论为尾结点的情况  2. 不需要进行while循环，只需要要改当前和下一个就好了")
    public boolean removeNode(ListNode pNode) {
        if (pNode ==  null || pNode.next == null) {
            return false;
        }
//        while (true) {
//            pNode.val = pNode.next.val;
//            if (pNode.next.next == null) {
//                pNode.next = null;
//                return true;
//            }
//            pNode = pNode.next;
//        }

        //while逻辑一个更简便的写法:
        pNode.val = pNode.next.val;
        pNode.next = pNode.next.next;
        return true;

    }
}
