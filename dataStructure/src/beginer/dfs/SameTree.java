package beginer.dfs;

import beginer.tree.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        return checkPre(p, q);
    }

    private boolean checkPre(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            if (!checkPre(p.left, q.left)) {
                return false;
            } else {
                return checkPre(p.right, q.right);
            }
        } else {
            return false;
        }
    }
}
