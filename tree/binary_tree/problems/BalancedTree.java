package tree.binary_tree.problems;

import tree.TreeNode;

public class BalancedTree {

    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root) != -1;
    }

    private int checkBalanced(TreeNode root) {
        if (root == null)
            return 0;
        int left = checkBalanced(root.left);
        int right = checkBalanced(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

}
