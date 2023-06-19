package tree.binary_tree.traversal;

import tree.TreeNode;

public class PostOrderTraversal {

    private void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.data);
    }

    public List<Integer> getTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        postorder(root, ans);
        return ans;
    }

}