package ru.kpfu.itis.group11408.zamaleev.hw15RedBlackTree;

/**
 * Created by Ilgiz on 13.04.2015.
 */
public class RedBlackTree<K extends Comparable<K>, V>{
    private Node root;
    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private boolean color;
        private int size;

        public K getKey() {
                    return key;
                }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Node(K key, V value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size= size;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return (x.color == RED);
    }

    private Node rotateRight(Node h) {
        // (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.setSize(h.getSize());
        h.setSize(h.left.getSize() + h.right.getSize() + 1);
        return x;
    }

    private Node rotateLeft(Node h) {
        // (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.setSize(h.getSize());
        h.setSize(h.left.getSize() + h.right.getSize() + 1);
        return x;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public RedBlackTree() {
        root = new Node(null, null, BLACK, -1);
    }

    public boolean isEmpty() {
        return root.getSize() > -1;
    }

    public V get(K key) {
        if (isEmpty()){
            try {
                throw new NullPointerException("Tree is empty!");
            } catch (NullPointerException e){
                e.printStackTrace();
            }
            return null;
        }
        return find(root, new Node(key, null, BLACK, 0));
    }

    private V find(Node parent, Node node) {
        int i = parent.getKey().compareTo(node.getKey());
        V result = null;
        if (i > 0) {
            if (parent.left == null) {
                result = null;
            } else {
                result = find(parent.left, node);
            }
        } else if (i < 0) {
            if (parent.right == null) {
                result = null;
            } else {
                result = find(parent.right, node);
            }
        } else {
            result = parent.getValue();
        }
        return result;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, K key, V value) {
        if (h == null){
            return new Node(key, value, RED, 1);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0){
            h.left  = put(h.left,  key, value);
        } else if (cmp > 0){
            h.right = put(h.right, key, value);
        } else {
            h.value   = value;
        }
        if (isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        if (isRed(h.left)  &&  isRed(h.left.left)){
            h = rotateRight(h);
        }
        if (isRed(h.left)  &&  isRed(h.right)){
            flipColors(h);
        }
        h.setSize(h.left.getSize() + h.right.getSize() + 1);
        return h;
    }
}
