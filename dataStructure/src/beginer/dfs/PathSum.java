package beginer.dfs;

import beginer.tree.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, 0, sum);
    }

    private boolean helper(TreeNode root, int cur, int target) {
        cur = cur + root.val;
        if(cur == target && root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            if (helper(root.left, cur, target)) {
                return true;
            }
        }
        if (root.right != null) {
            if (helper(root.right, cur, target)) {
                return true;
            }
        }
        return false;
    }

}
