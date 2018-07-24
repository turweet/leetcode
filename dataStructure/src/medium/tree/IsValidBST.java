package medium.tree;

import apple.laf.JRSUIUtils;
import beginer.tree.TreeNode;
import jdk.nashorn.internal.ir.IfNode;
import org.junit.Assert;
import org.junit.Test;
import summary.Attention;

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
                if (data.get(i + 1).val <= data.get(i).val) {
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

    public boolean isValidBSTBetter(TreeNode root) {
        return inorder2(root);
    }

    static int pre = Integer.MIN_VALUE;

    @Attention("这里犯了难，还是需要好好看看啊")
    public static boolean inorder2(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!inorder2(node.left)) {
            return false; //一旦左侧有不符合的情况就直接打断
        }
        if (pre > node.val) {
            return false;
        }
        pre = node.val;
        if (!inorder2(node.right)) {
            return false;//一旦右侧有不符合的情况就直接打断
        }
        return true;
    }

    public boolean isValidBST_Best(TreeNode node) {
        return inner_best(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean inner_best(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) {
            return false;
        }
        if (!inner_best(node.left, min, node.val)) {
            return false;
        }
        if (!inner_best(node.right, node.val, max)) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertEquals(true, isValidBSTBetter(new TreeNode(0)));
    }
}
