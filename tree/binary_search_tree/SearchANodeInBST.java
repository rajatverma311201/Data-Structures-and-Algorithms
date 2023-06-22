package tree.binary_search_tree;

import tree.TreeNode;

public class SearchANodeInBST {

    public boolean search(TreeNode root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key > root.data) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }

    }

}
