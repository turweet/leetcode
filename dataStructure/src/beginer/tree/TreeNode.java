package beginer.tree;

import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public static LinkedList<TreeNode> inorder(TreeNode node,LinkedList<TreeNode> container) {
        if (node == null) {
            return container;
        }
        inorder(node.left, container);
        container.add(node);
        inorder(node.right, container);
        return container;
    }
}
