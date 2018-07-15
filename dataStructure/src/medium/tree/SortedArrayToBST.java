package medium.tree;

import beginer.tree.TreeNode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 主要问题在mid的计算上，先把mid算出来，而不是只算出长度，然后在里边再除以2， 然后加一，减一，先算出mid来更清楚
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            TreeNode node = new TreeNode(nums[end]);
            node.right = null;
            node.left = null;
            return node;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }
}
