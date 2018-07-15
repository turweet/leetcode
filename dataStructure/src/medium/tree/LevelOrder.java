package medium.tree;

import beginer.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    /**
     * 感觉这道题本来可以做出来的，我开始也想到了levelNum这种但是没有深入思考，看了一半的答案有levelNum又继续进行下去了
     * 想想也是啊，既然要分层，就要记住每层有几个元素就好了
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int levelNum = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int temp = levelNum;
            levelNum = 0;
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < temp; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    levelNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    levelNum++;
                }
            }
            result.add(level);
        }
        return result;
    }
}
