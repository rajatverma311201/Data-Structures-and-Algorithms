package tree.binary_tree.problems;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class RootToNodePathInTree {

    private boolean findPathList(TreeNode root, int x, List<Integer> ans) {

        if (root == null) {
            return false;
        }

        ans.add(root.data);

        if (root.data == x) {
            return true;
        }

        boolean goLeft = findPathList(root.left, x, ans);
        boolean goRight = findPathList(root.right, x, ans);

        if (goLeft || goRight) {
            return true;
        }

        ans.remove(ans.size() - 1);

        return false;

    }

    public List<Integer> getPath(TreeNode root, int x) {

        List<Integer> path = new ArrayList<>();

        findPathList(root, x, path);

        return path;
    }

}
