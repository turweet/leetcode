import javax.xml.bind.ValidationEvent;

public class BinarySearchTree<Key extends Comparable, Value> {
    private Node root;

    public class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public int getSize() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node node, Key key) {
        if (node == null || key == null) {
            return null;
        }
        int comp = node.key.compareTo(key);
        if (comp < 0) {
            return get(node.right, key);
        } else if (comp > 0) {
            return get(node.left, key);
        } else {
            return node.value;
        }

    }


    public Node put(Key key, Value value) {
        return put(root, key, value);
    }

    public Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int comp = node.key.compareTo(key);
        if (comp < 0) {
            node.right = put(node.right, key, value);
        } else if (comp > 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }
        node.size = size(node.right) + size(node.right) + 1;
        return root;

    }

    public Node max(Node node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node;
        }
    }

    public Node min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node;
        }
    }

    /**
     * 在二叉树root中找出小于等于target的最大值
     * @param root
     * @param target
     * @return
     */
    public Node floor(Node root, Node target) {
        int comp = root.key.compareTo(target.key);
        if (comp > 0) {
            if ()
        } else if (comp < 0) {

        } else {
            return root;
        }
    }

}
