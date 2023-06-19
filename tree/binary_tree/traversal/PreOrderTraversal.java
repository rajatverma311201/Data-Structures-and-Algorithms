package tree.binary_tree.traversal;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class PreOrderTraversal {

    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.data);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    public List<Integer> getTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        preorder(root, ans);
        return ans;
    }

}