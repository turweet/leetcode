package medium.tree;

public class Connect {

    public void connect(TreeLinkNode root) {
        if (root ==null || root.left == null) {
            return;
        }
        connect(root.left, root.right);
    }

    private void connect(TreeLinkNode q, TreeLinkNode p) {
        if (q == null) {
            return;
        }
        q.next = p;
        if (q.left != null) {
            connect(q.left, q.right);
            connect(q.right, p.left);
            connect(p.left, p.right);
        }
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}

