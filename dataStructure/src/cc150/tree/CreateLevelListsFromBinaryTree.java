package cc150.tree;

import base.tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class CreateLevelListsFromBinaryTree {
    public ArrayList<LinkedList<BinaryTreeNode>> create_byDFS(BinaryTreeNode node) {
        ArrayList<LinkedList<BinaryTreeNode>> result = new ArrayList<>();
        create(result, node, 0);
        return result;
    }

    private void create(ArrayList<LinkedList<BinaryTreeNode>> linkedLists,
                        BinaryTreeNode root,
                        int level) {
        if (root == null) return;
        LinkedList<BinaryTreeNode> list = null;
        if (linkedLists.size() >= level) {
            list = new LinkedList<>();
            linkedLists.add(list);
        } else {
            list = linkedLists.get(level);
        }
        list.add(root);
        create(linkedLists, root.getLeft(), level + 1);
        create(linkedLists, root.getRight(), level + 1);
    }

    public ArrayList<LinkedList<BinaryTreeNode>> create_byBFS(BinaryTreeNode node) {
        ArrayList<LinkedList<BinaryTreeNode>> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        LinkedList<BinaryTreeNode> current = new LinkedList<>();
        current.add(node);
        while (current.size() > 0) {
            result.add(current);
            LinkedList<BinaryTreeNode> parent = current;
            current = new LinkedList<>();
            for (BinaryTreeNode n :
                    parent) {
                if (n.getRight() != null) {
                    current.add(n.getRight());
                }
                if (n.getLeft() != null) {
                    current.add(n.getLeft());
                }
            }
        }
        return result;
    }
}
