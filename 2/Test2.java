import java.util.ArrayList;
import java.util.List;

public class Test2 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 理解题意，方法2更简单
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode mlist = new ListNode(-1);
        ListNode result = mlist;

        int carry = 0;
        do {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int z = x + y + carry;
            if (z > 9) {
                carry = 1;
                mlist.next = new ListNode(z - 10);
            } else {
                carry = 0;
                mlist.next = new ListNode(z);
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            mlist = mlist.next;
        } while (l1 != null || l2 != null);
        if (carry == 1) {
            mlist.next = new ListNode(1);
        }
        return result.next;

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int[] a1 = getReverseArray(l1);
        int[] a2 = getReverseArray(l2);

        int[] a3 = plusTwoIntArray(a1, a2);

        ListNode ln = new ListNode(a3[a3.length - 1]);
        ListNode resultLn = ln;
        for (int i = a3.length - 2; i >= 0; i--) {
            ln.next = new ListNode(a3[i]);
            ln = ln.next;
        }
        return resultLn;
    }

    public int[] getReverseArray(ListNode l1) {
        List<Integer> list1 = new ArrayList();
        do {
            list1.add(l1.val);
            l1 = l1.next;
        } while (l1 != null);
        int[] array1 = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            array1[i] = list1.get(list1.size() - 1 - i);
        }
        return array1;
    }


    public static int[] plusTwoIntArray(int[] a1, int[] a2) {
        int a1Len = a1.length;
        int a2Len = a2.length;
        int[] notChange;
        int[] expandedWithZero;
        int bigLen;
        if (a1Len > a2Len) {
            notChange = a1;
            bigLen = a1Len;
            expandedWithZero = expandArrayWithZero(a2, bigLen);
        } else if (a1Len < a2Len) {
            notChange = a2;
            bigLen = a2Len;
            expandedWithZero = expandArrayWithZero(a1, bigLen);
        } else {
            notChange = a1;
            expandedWithZero = a2;
            bigLen = a1Len;
        }

        // 将两个等长int数组的对应值相加放到另一个数组中。
        int[] resultStep1 = new int[bigLen];
        for (int i = 0; i < bigLen; i++) {
            resultStep1[i] = notChange[i] + expandedWithZero[i];
        }

        //加0站位
        int[] resultStep2 = new int[bigLen + 1];
        resultStep2[0] = 0;
        for (int i = 0; i < bigLen; i++) {
            resultStep2[i + 1] = resultStep1[i];
        }

        //将大于10的进一位
        for (int i = resultStep2.length - 1; i >= 1; i--) {
            if (resultStep2[i] > 9) {
                resultStep2[i - 1] += 1;
                resultStep2[i] -= 10;
            }
        }

        //如果第一位为0则去掉
        if (resultStep2[0] == 0) {
            int[] resultStep3 = new int[resultStep2.length - 1];
            for (int i = 1; i < resultStep2.length; i++) {
                resultStep3[i - 1] = resultStep2[i];
            }
            return resultStep3;
        } else {
            return resultStep2;
        }


    }


    /**
     * 将0插入到数组的前边以达到填充满的效果
     *
     * @param origin
     * @param expandedLength
     * @return
     */
    public static int[] expandArrayWithZero(int[] origin, int expandedLength) {
        int[] expandedWithZero = new int[expandedLength];
        int originlen = origin.length;
        if (expandedLength <= originlen) {
            return origin;
        }
        for (int i = 0; i < originlen; i++) {
            expandedWithZero[i] = origin[originlen - 1 - i];
        }
        for (int i = originlen; i < expandedLength; i++) {
            expandedWithZero[i] = 0;
        }
        int[] result = new int[expandedLength];
        for (int i = 0; i < expandedLength; i++) {
            result[i] = expandedWithZero[expandedLength - 1 - i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a2 = {1, 8, 3};
        int[] a1 = {7, 1};
        int[] result = plusTwoIntArray(a1, a2);
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

}
