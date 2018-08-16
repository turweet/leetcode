package medium.tree;

import beginer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BuildTree {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//
//    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (inStart > inEnd) {
            return null;
        }

        int root = preorder[preStart];
        int leftCount = 0;
        int rightCount = 0;
        int index = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] != root) {
                leftCount++;
            } else {
                rightCount = inEnd - inStart - leftCount;
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(root);
        node.left = buildTree(preorder, preStart + 1, preStart + leftCount,
                inorder, inStart, inStart + leftCount);
        node.right = buildTree(preorder, preStart + leftCount, preStart + leftCount + rightCount,
                inorder, index + 1, inEnd);
        return null;
    }


    /**
     * 耗时太多，并且需要的额外空间也太多
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_bad(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        List<Integer> pre = new ArrayList<>();
        for (int i : preorder) {
            pre.add(i);
        }
        List<Integer> in = new ArrayList<>();
        for (int i : inorder) {
            in.add(i);
        }
        return buildTree_bad(pre, in);
    }

    private TreeNode buildTree_bad(List<Integer> preorder, List<Integer> inorder) {
        if (preorder == null || preorder.size() == 0) return null; //这里为null和长度为0的情况没有考虑到
        if (inorder == null || inorder.size() == 0) return null;
        int root = preorder.get(0);
        int len = preorder.size();
        if (len == 1) {
            return new TreeNode(root);
        }
        List<Integer> leftPre = new ArrayList<>();
        List<Integer> lefIn = new ArrayList<>();
        List<Integer> rightPre = new ArrayList<>();
        List<Integer> rightIn = new ArrayList<>();
        int leftCount = 0;
        boolean addToRight = false;

        for (int i = 0; i < len; i++) {
            if (addToRight) {
                rightIn.add(inorder.get(i));
            } else {
                if (inorder.get(i) == root) {
                    addToRight = true;
                } else {
                    leftCount++;
                    lefIn.add(inorder.get(i));
                }
            }
        }

        for (int i = 1; i < len; i++) {
            if (leftCount > 0) {
                leftPre.add(preorder.get(i));
                leftCount--;
            } else {
                rightPre.add(preorder.get(i));
            }
        }
        TreeNode node = new TreeNode(root);
        node.left = buildTree_bad(leftPre, lefIn);
        node.right = buildTree_bad(rightPre, rightIn);
        return node;
    }
}
