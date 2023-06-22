package tree.binary_search_tree;

import tree.TreeNode;

public class CeilInBST {

    public int getCeil(TreeNode root, int key) {

        int ans = -1;

        while (root != null) {
            if (root.data == key) {
                ans = root.data;
                break;
            }

            if (key > root.data) {
                root = root.right;
            } else {
                ans = root.data;
                root = root.left;
            }
        }

        return ans;
    }

}
