package base.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 3种遍历，参考：https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 */
public class Traversal {
    BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
    BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
    BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
    BinaryTreeNode node3 = new BinaryTreeNode(3, null, null);
    BinaryTreeNode node2 = new BinaryTreeNode(2, node5, node6);
    BinaryTreeNode node1 = new BinaryTreeNode(1, node3, node4);
    BinaryTreeNode node0 = new BinaryTreeNode(0, node1, node2);


    /**
     * 中序优先遍历：左根右
     * 3 1 4 0 5 2 6
     *
     * @param node
     */
    public void inorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getVal() + " ");
        inorder(node.getRight());
    }

    /**
     * 前序优先遍历：根左右
     * 0 1 3 4 2 5 6
     *
     * @param node
     */
    public void preorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getVal() + " ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    /**
     * 后续优先遍历：左右根
     * 3 4 1 5 6 2 0
     *
     * @param node
     */
    public void postorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getVal() + " ");
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        traversal.inorder(traversal.node0);
        System.out.println();
        traversal.preorder(traversal.node0);
        System.out.println();
        traversal.postorder(traversal.node0);
        System.out.println();
        traversal.bfs(traversal.node0);
        System.out.println();
        traversal.bfs2(traversal.node0);
    }

    /**
     * 层次遍历
     *
     * @param node
     */
    public void bfs(BinaryTreeNode node) {
        int height = BinaryTreeNode.getHeight(node);
        if (height <= 0) {
            return;
        }
        for (int i = 1; i <= height; i++) {
            printGivenLevel(node, i);
        }
    }

    public void printGivenLevel(BinaryTreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.getVal() + " ");
        } else {
            printGivenLevel(node.getLeft(), level - 1);
            printGivenLevel(node.getRight(), level - 1);
        }
    }

    /**
     * 利用队列进行层次遍历
     * @param node
     */
    public void bfs2(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryTreeNode treeNode= queue.poll();
            System.out.print(treeNode.getVal() + " ");
            if (treeNode.getLeft() != null) {
                queue.add(treeNode.getLeft());
            }
            if (treeNode.getRight() != null) {
                queue.add(treeNode.getRight());
            }
        }
    }
}
