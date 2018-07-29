package medium.tree;

import beginer.tree.TreeNode;
import summary.Attention;
import summary.MustNeedContinue;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * <p>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often
 * and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 * 回答：我会随着modify来一直维护一个linkedList，对应进行modify，这样就不需要每次遍历了
 * <p>
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63660/3-ways-implemented-in-JAVA-(Python):-Binary-Search-in-order-iterative-and-recursive
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        if (k > list.size()) {
            throw new IllegalArgumentException();
        } else {
            return list.get(k - 1);
        }
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }


    int count = 0;
    int result = 0;

    @Attention("这种解法很好啊")
    public int kthSmallestBetter(TreeNode root, int k) {
        inorderbetter(root, k);
        return result;
    }

    private void inorderbetter(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inorderbetter(node.left, k);
        count++;
        if (count == k) {
           result = node.val;
           return;
        }
        inorderbetter(node.right, k);
    }


}
