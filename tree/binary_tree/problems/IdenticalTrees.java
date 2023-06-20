package tree.binary_tree.problems;

import tree.TreeNode;

public class IdenticalTrees {

    boolean areIdentical(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        if (root1.data != root2.data) {
            return false;
        }

        boolean leftIdentity = areIdentical(root1.left, root2.left);
        boolean rightIdentity = areIdentical(root1.right, root2.right);

        return leftIdentity && rightIdentity;
    }

}
