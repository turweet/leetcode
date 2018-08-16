package hard.list;

import beginer.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) throw new NullPointerException("lists == null");
        if (lists.length == 0) {
            return null;
        }
        int len = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<Wrapper> queue = new PriorityQueue<>(len, new Comparator<Wrapper>() {
            @Override
            public int compare(Wrapper o1, Wrapper o2) {
                return Integer.compare(o1.node.val, o2.node.val);
            }
        });
        for (int i = 0; i < len; i++) {
            if (lists[i] == null) {
                continue;
            }
            queue.add(new Wrapper(i, lists[i]));
        }
        while (!queue.isEmpty()) {
            Wrapper wrapper = queue.remove();
            cur.next = wrapper.node;
            cur = cur.next;
            if (lists[wrapper.key].next != null) {
                lists[wrapper.key] = lists[wrapper.key].next;
                queue.offer(new Wrapper(wrapper.key, lists[wrapper.key]));
            }
        }
        cur.next = null;
        return dummy.next;
    }

    private static class Wrapper {
        public int key;
        public ListNode node;

        public Wrapper(int key, ListNode node) {
            this.key = key;
            this.node = node;
        }
    }
}
