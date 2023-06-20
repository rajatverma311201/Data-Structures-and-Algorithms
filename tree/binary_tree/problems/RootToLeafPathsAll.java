package tree.binary_tree.problems;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

/**
 * 
 * 
 * https://leetcode.com/problems/binary-tree-paths/description/
 * 
 * 
 * 
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 * 
 * 
 * 
 */

public class RootToLeafPathsAll {

    private void findPaths(TreeNode root, List<List<Integer>> paths, List<Integer> list) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.data);
            paths.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.data);

        findPaths(root.left, paths, list);
        findPaths(root.right, paths, list);

        list.remove(list.size() - 1);

    }

    public List<List<Integer>> getAllPaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, paths, new ArrayList<>());
        return paths;
    }

    // LEETCODE ANSWER FOR THIS BY USING List<String>
    public List<String> binaryTreePaths(TreeNode root) {

        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, paths, new ArrayList<>());

        List<String> ans = new ArrayList<>();

        for (List<Integer> li : paths) {
            ans.add(convertListToString(li));
        }

        return ans;
    }

    private String convertListToString(List<Integer> li) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < li.size() - 1; i++) {
            sb.append(li.get(i).toString() + "->");

        }

        sb.append(li.get(li.size() - 1));

        return sb.toString();
    }

}
