package medium.tree;

import beginer.tree.TreeNode;
import summary.Attention;

import java.util.ArrayList;
import java.util.List;

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


    List<TreeNode> list = new ArrayList<>();
    int pp;
    int qp;
    boolean hasFindP;
    boolean hasFindQ;

    public void lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (hasFindP && hasFindQ) {
            return;
        }
        if (!hasFindP && hasFindQ) {
            if (root.val == p.val) {
                lowestCommonAncestor(null, null, null);
            }
        }
        if (!hasFindQ && hasFindP) {
            if (root.val == q.val) {
                lowestCommonAncestor(null, null, null);
            }
        }
        lowestCommonAncestor2(root.left, p, q);
        lowestCommonAncestor2(root.right, p, q);
    }


}
