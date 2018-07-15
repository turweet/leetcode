package medium.tree;

import beginer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {

    /**
     * 使用中序遍历，如果能得到一个递增的数组即为正确
     * 这个On空间复杂度的程序还可以优化为O1的空间复杂度：
     * 中序遍历时每次记住上次的值，这次的值不能比上次的值小就可以了
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<TreeNode> data = inorder(root, new ArrayList<>());
        if (data.size() > 1) {
            for (int i = 0; i < data.size() - 1; i++) {
                if (data.get(i + 1).val <=data.get(i).val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<TreeNode> inorder(TreeNode node, List<TreeNode> container) {
        if (node == null) {
            return container;
        }
        inorder(node.left, container);
        container.add(node);
        inorder(node.right, container);
        return container;
    }


}
