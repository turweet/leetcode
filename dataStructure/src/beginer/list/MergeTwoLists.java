package beginer.list;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode list = result;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    list.next = l1;
                    l1 = l1.next;
                } else {
                    list.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null && l2 == null) {
                list.next = l1;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }
        return result.next;
    }
}
//总结：
//题目本身不是很难，不过，指针问题让人很懵逼，要注意啊！
//如果result开始为null，你把list指向了result，然后list再指向别人result也不会变啊
//因为只改变了list的指针，没有改变result的指针，result不会变啊，所以要用一个有初始值
//的result来做这件事！