package medium.tree;


public class Connect2 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connect(root.left, root.right);
    }

    private void connect(TreeLinkNode left, TreeLinkNode right) {
        if (left != null) {
            left.next = right;
            if (left.left != null && left.right != null) {
                connect(left.left, left.right);
            } else if (left.left != null && right != null && right.left != null) {
                connect(left.left, right.left);
            } else if (left.left != null && right != null && right.right != null) {
                connect(left.left, right.right);
            } else if (left.right != null && right != null && right.left != null) {
                connect(left.right, right.right);
            } else if (left.right != null && right != null && right.right != null) {
                connect(left.right, right.right);
            }
        }
        if (right != null) {
            connect(right.left, right.right);
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
