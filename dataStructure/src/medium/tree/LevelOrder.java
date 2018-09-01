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
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int levelNum = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int tempNum = levelNum;
            levelNum = 0;
            List<Integer> list = new ArrayList<>(); //每次都需要new出对象不能在外边申请然后每次clear
            while (tempNum > 0) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    levelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    levelNum++;
                }
                tempNum--;
            }
            ans.add(list);
        }
        return ans;
    }
}
