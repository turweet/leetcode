package beginer.tree;

import summary.Attention;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * _______6______
 * /              \
 * ___2__          ___8__
 * /      \        /      \
 * 0      _4       7       9
 * /  \
 * 3   5
 * <p>
 * Example 1:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * <p>
 * Example 2:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 * according to the LCA definition.
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class LowestCommonAncestor {
    @Attention
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }

    public TreeNode lowestCommonAncestor_timeLimit(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        findToNode(root, p, stack1);
        findToNode(root, q, stack2);
        Set<Integer> set = new HashSet<>();
        while (!stack1.isEmpty()) {
            set.add(stack1.pop().val);
        }
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.peek();
            if (set.contains(node.val)) {
                return node;
            }
        }
        return null;
    }

    private void findToNode(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null || target == null) return;
        if (root == target) return;
        stack.push(root);
        if (root.val < target.val) {
            findToNode(root.right, target, stack);
        } else {
            findToNode(root.left, target, stack);
        }
    }
}
