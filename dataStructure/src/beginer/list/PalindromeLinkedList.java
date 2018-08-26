package beginer.list;

import org.junit.Test;
import summary.Attention;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * <p>
 * <p>
 * 思路：
 * 1. 第一个想到的方法是把结点的值都放入数组中，从头尾同时开始遍历数组非常方便了
 * 2. 第二个想到的方法是创建一个逆序的结点list，然后同时遍历正序和逆序的到最后还相等的话就没问题
 * 3. 参考了别人的做法，他没有额外的空间来存储全部结点，但仍需要遍历一遍,不过的slow fast指针不错！
 * 4. 还可以用栈来做，遍历一次存入栈中，然后再遍历一次同时从栈中pop数据如果到结束都一致就是回文了
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 其实这里不需要把全部内容放到栈里边，只需要放一半然后从中间开始比较链表和出栈内容即可
     * 注意中间位置的判定奇偶不一样的
     * @param head
     * @return
     */
    @Attention("这里的Stack里边的泛型有Integer就没有问题，用ListNode本身就有问题," +
            "因为stack是相反的放的，比较的时候不是同一个对象，只能比较里边的值了")
    public boolean isPalindromeWithStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop()!=head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 5};
//        ListNode node = ListNode.create(array);
//        isPalindrome(node);
//        ListNode.printList(node);
    }
}
