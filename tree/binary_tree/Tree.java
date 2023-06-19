package tree.binary_tree;

import tree.TreeNode;
import tree.binary_tree.traversal.LevelOrderTraversal;

public class Tree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);

        LevelOrderTraversal lot = new LevelOrderTraversal();

        System.out.println(lot.levelorder(root));

    }

}
