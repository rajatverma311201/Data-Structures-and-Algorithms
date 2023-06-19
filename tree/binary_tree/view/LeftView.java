package tree.binary_tree.view;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class LeftView {

    private void traverseView(TreeNode root, List<Integer> ans, int level) {

        if (root == null) {
            return;
        }

        if (ans.size() == level) {
            ans.add(root.data);
        }

        traverseView(root.left, ans, level + 1);
        traverseView(root.right, ans, level + 1);

    }

    public List<Integer> getView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        traverseView(root, ans, 0);

        return ans;

    }

}
