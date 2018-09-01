package medium.tree;

import beginer.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


/**
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 * <p>
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * <p>
 * bst的中序遍历是按照顺序输出的
 */
public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        putLeftSideToBottom(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (hasNext()) {
            TreeNode node = stack.pop();
            putLeftSideToBottom(node.right);
            return node.val;
        } else {
            throw new IllegalStateException();
        }
    }

    private void putLeftSideToBottom(TreeNode node) {
        if (node != null) {
            stack.push(node);
            putLeftSideToBottom(node.left);
        }
    }
}
