package medium.tree;

import beginer.tree.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {
    /**
     * times:3
     * 整体上还是比较复杂的，开始想着用queue用stack都不行，不过后来稍微看了下答案
     * 看到了List有add(int,E e)的方法，可以从0插入进去，这就让回旋的结果有了着落
     * 不过这样的话就不是按照题目中的顺序遍历了，只是输出的结果是那个顺序
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        boolean isOdd = false;
        int levelNum = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int newLevel = 0;
            List<Integer> current = new ArrayList<>();
            while (levelNum != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    newLevel++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevel++;
                }
                if (isOdd) {
                    current.add(0, node.val);
                } else {
                    current.add(node.val);
                }
                levelNum--;
            }
            result.add(current);
            isOdd = !isOdd;
            levelNum = newLevel;
        }
        return result;
    }
}
