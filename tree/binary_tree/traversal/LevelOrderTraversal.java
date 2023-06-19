package tree.binary_tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class LevelOrderTraversal {

    public List<List<Integer>> levelorder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                li.add(node.data);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(new ArrayList<>(li));
        }
        return ans;
    }
}