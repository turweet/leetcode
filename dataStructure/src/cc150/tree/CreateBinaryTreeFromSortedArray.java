package cc150.tree;

import base.tree.BinaryTreeNode;

public class CreateBinaryTreeFromSortedArray {
    public BinaryTreeNode create(int[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        int len = vals.length;
        return inner(vals, 0, len - 1);
    }

    private BinaryTreeNode inner(int[] arr, int start, int end) {
        if (start < end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        return new BinaryTreeNode(arr[mid],
                inner(arr, start, mid - 1),
                inner(arr, mid + 1, end));
    }
}
