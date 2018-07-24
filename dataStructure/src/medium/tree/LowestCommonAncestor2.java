package medium.tree;

import beginer.tree.TreeNode;
import summary.Attention;

public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (cover(root.left, p) && cover(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (cover(root.right, p) && cover(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    @Attention("判定一个节点是否在树种")
    private boolean cover(TreeNode node, TreeNode target) {
        if (node == null) return false;
        if (node.val == target.val) return true;
        return cover(node.left, target) || cover(node.right, target);
    }
}
