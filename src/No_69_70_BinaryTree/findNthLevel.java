package No_69_70_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class findNthLevel {
    public static void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void nthLevel(TreeNode root, int n) {
        if (root == null) return;

        if (n == 1) System.out.print(root.val + " ");
        nthLevel(root.left, n - 1);
        nthLevel(root.right, n - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(7);
        root.left = a;
        root.right = b;

        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        a.left = c;
        a.right = d;
        TreeNode e = new TreeNode(1);
        b.right = e;
//        nthLevel(root, 3);

        Queue<TreeNode> q = new LinkedList<>();
        int i = 1;
        q.offer(root);
        while (!q.isEmpty()) {
            int j = 0;
            List<Integer> list = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
                list.add(temp.val);
                j++;
                if (j == i) break;
            }
            System.out.println(list);
            i++;
        }
    }
}
