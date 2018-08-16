package medium.tree;

import beginer.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    private static final String SPLITER = ",";
    private static final String NULL = "n";
    private StringBuilder stringBuilder = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return NULL;
        serivlize(root);
        return stringBuilder.toString();
    }

    public void serivlize(TreeNode root) {
        if (root == null) {
            return;
        } else {
            stringBuilder.append(root.val).append(SPLITER);
            serivlize(root.left);
            serivlize(root.right);
        }
    }

    // Decodes your encoded data to tree.
    //前序遍历，正好比根小的都在左边，比根大的都在右边
    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        String[] ss = data.split(SPLITER);
        for (String s : ss) {
            queue.add(s);
        }
        return toNodes(queue);
    }

    private TreeNode toNodes(Queue<String> origin) {
        if (origin == null || origin.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(origin.poll()));
        Queue<String> leftQueue = new LinkedList<>();
        while (!origin.isEmpty() && Integer.parseInt(origin.peek()) < root.val) {
            leftQueue.offer(origin.poll());
        }
        root.left = toNodes(leftQueue);
        root.right = toNodes(origin);
        return root;
    }
}
