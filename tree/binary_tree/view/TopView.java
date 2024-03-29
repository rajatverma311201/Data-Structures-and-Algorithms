package tree.binary_tree.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.TreeMap;

import tree.TreeNode;
import utils.Pair;

public class TopView {

    public List<Integer> getView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        Map<Integer, Integer> mp = new TreeMap<>();

        q.offer(new Pair<TreeNode, Integer>(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.first;
            int level = pair.second;

            if (!mp.containsKey(level)) {
                mp.put(level, node.data);
            }

            if (node.left != null) {
                q.offer(new Pair<TreeNode, Integer>(node.left, level - 1));
            }
            if (node.right != null) {
                q.offer(new Pair<TreeNode, Integer>(node.right, level + 1));
            }
        }
        for (int key : mp.keySet()) {
            ans.add(mp.get(key));
        }
        return ans;
    }

}
