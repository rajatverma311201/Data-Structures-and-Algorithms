package tree.binary_tree.problems;

import tree.TreeNode;

public class SymmetricalTree {

    boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        if (root1.data != root2.data) {
            return false;
        }

        boolean mirrorFar = isMirror(root1.left, root2.right);
        boolean mirrorNear = isMirror(root1.right, root2.left);

        return mirrorFar && mirrorNear;

    }

    boolean isSymmetrical(TreeNode root) {

        return isMirror(root, root);
    }

}
