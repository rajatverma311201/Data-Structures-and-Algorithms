package tree.binary_tree.traversal;

import tree.TreeNode;

public class InOrderTraversal {

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    public List<Integer> getTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        inorder(root, ans);
        return ans;
    }

}