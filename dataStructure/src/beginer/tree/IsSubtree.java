package beginer.tree;


import summary.Attention;

@Attention("书中复杂度的推导需要好好看看")
public class IsSubtree {

    public boolean isSubtree_withIterator(TreeNode s, TreeNode t) {
        StringBuffer preS = new StringBuffer();
        preOrderString(s, preS);
        StringBuffer preT = new StringBuffer();
        preOrderString(t, preT);
        StringBuffer inS = new StringBuffer();
        inOrderString(s, inS);
        StringBuffer inT = new StringBuffer();
        inOrderString(t, inT);
        return preS.toString().contains(preT.toString()) && inS.toString().contains(inT.toString());
    }

    @Attention("为null的时候append，这里不能用 0 或者是其他数字，因为可能和树本身的值冲突导致结果异常，所以用了这个与数字无关的i")
    private void preOrderString(TreeNode node, StringBuffer s) {
        if (node == null) {
            s.append("i");
            return;
        }
        s.append(node.val);
        preOrderString(node.left, s);
        preOrderString(node.right, s);
    }

    @Attention("这样获取不到")
    private String inOrderString_wrong(TreeNode node, String s) {
        if (node == null) {
            s += "i";
            return s;
        }
        s += inOrderString_wrong(node.left, s);
        s += node.val;
        s += inOrderString_wrong(node.right, s);
        return s;
    }

    @Attention("这样才能获取到")
    private void inOrderString(TreeNode node, StringBuffer s) {
        if (node == null) {
            s.append("i");
            return;
        }
        inOrderString(node.left, s);
        s.append(node.val);
        inOrderString(node.right, s);
    }

    public static void main(String[] args) {
        IsSubtree subtree = new IsSubtree();
        boolean ret = subtree.isSubtree_withIterator(TreeNode.stringArrayToTreeNode("[-5,-8,-4,-9,-7,null,6,null,null,null,null,3,null,-2,null,null,-1,null,0]"),
                TreeNode.stringArrayToTreeNode("[-2,null,-1]"));
        System.out.println(ret);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null) return false;
        if (s.val == t.val) {
            if (TreeNode.totalMatch(s, t)) {
                return true;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }


}

