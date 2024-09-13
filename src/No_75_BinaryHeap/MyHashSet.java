package No_75_BinaryHeap;

import java.util.Collections;
import java.util.PriorityQueue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MyHashSet {
    TreeNode root;

    public MyHashSet() {
        root = null;
    }

    private TreeNode insertNode(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);
        }
        if (key < node.val) {
            node.left = insertNode(node.left, key);
        }
        if (key > node.val) {
            node.right = insertNode(node.right, key);
        }
        return node;
    }

    public void add(int key) {
        if (!contains(key)) {
            root = insertNode(root, key);
        }
    }

    private TreeNode findLeftMax(TreeNode node) {
        if (node == null) return null;
        while (node.right != null) node = node.right;
        return node;
    }

    private TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) return null;

        if (key < node.val) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.val) {
            node.right = deleteNode(node.right, key);
        } else {

            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            TreeNode max = findLeftMax(node.left);

            node.val = max.val;

            node.left = deleteNode(node.left, max.val);
        }
        return node;
    }

    public void remove(int key) {
        if (root == null) return;
        root = deleteNode(root, key);
    }

    private boolean containsNode(TreeNode node, int key) {
        if (node == null) return false;

        if (node.val == key) return true;

        if (key < root.val) return containsNode(node.left, key);
        else return containsNode(node.right, key);

    }

    public boolean contains(int key) {
        return containsNode(root, key);
    }

    private void inOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.val).append(", ");
        inOrder(node.left, sb);
        inOrder(node.right, sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        inOrder(root, sb);

        //remove extra comma and space
        sb.delete(sb.length() - 2, sb.length());
        //add closing bracket at the end;
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(5);
        set.add(2);
        set.add(4);
        set.add(1);
        set.remove(3);
        System.out.println(set.contains(3));
        new PriorityQueue<>(Collections.reverseOrder());
    }
}
