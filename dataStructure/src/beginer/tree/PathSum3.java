package beginer.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSum3 {
    public int count = 0;

    /**
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        count = 0;
        return innerSum(root, sum);
    }

    public int innerSum(TreeNode root, int sum) {
        if (root == null) {
            return count;
        }
        checkSum(root, sum, true);
        checkSum(root, sum, false);
        if (root.val == sum) {
            count--;
        }
        innerSum(root.left, sum);
        innerSum(root.right, sum);
        return count;
    }

    private void checkSum(TreeNode node, int sum, boolean left) {
        int add = 0;
        while (node != null) {
            add += node.val;
            if (add == sum) {
                count++;
            }
            if (left) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(3, pathSum(TreeNode.stringArrayToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]"),
                22));
    }
}
