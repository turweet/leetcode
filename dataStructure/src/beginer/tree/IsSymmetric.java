package beginer.tree;

import java.util.Stack;

public class IsSymmetric {
    /**
     * 递归方式
     * times: 1
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return inner(root.left, root.right);
    }

    public boolean inner(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val == right.val) {
            return inner(left.left, right.right) && inner(left.right, right.left);
        } else {
            return false;
        }
    }

    /**
     * 循环方式
     * times: 1
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (right == null && left == null) {
                continue;
            } else if (right == null || left == null) {
                return false;
            } else if (right.val == left.val) {
                stack.push(left.left);
                stack.push(right.right);
                stack.push(left.right);
                stack.push(right.left);
            } else {
                return false;
            }
        }
        return true;
    }


}
