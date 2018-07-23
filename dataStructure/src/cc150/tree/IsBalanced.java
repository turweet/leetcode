package cc150.tree;

import beginer.tree.TreeNode;

public class IsBalanced {
    public boolean isBalancedBad(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (Math.abs(getHeight(left) -
                getHeight(right)) <= 1) {
//            if (left != null && right != null) {
//                return isBalancedBad(left) && isBalancedBad(right);
//            }
//            if (left == null && right == null) {
//                return true;
//            }
//            if (left == null && right != null) {
//                return isBalancedBad(left);
//            }
//            if (left != null && right == null) {
//                return isBalancedBad(left);
//            }
//            return true;
            //attention 直接这样简写即可：
            return isBalancedBad(left) && isBalancedBad(right);
        } else {
            return false;
        }
    }

    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);
        if (lHeight > rHeight) {
            return lHeight + 1;
        } else {
            return rHeight + 1;
        }
    }

    public boolean isBanlaced2(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = checkHeight(node.left);
        int r = checkHeight(node.right);
        if (l == -1) return -1;
        if (r == -1) return -1;
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
