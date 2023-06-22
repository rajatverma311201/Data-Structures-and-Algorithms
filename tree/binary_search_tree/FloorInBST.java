package tree.binary_search_tree;

import tree.TreeNode;

public class FloorInBST {

    public int getFloor(TreeNode root, int key) {
        int ans = -1;

        while (root != null) {
            if (root.data == key) {
                ans = root.data;
                break;
            }

            if (key < root.data) {
                root = root.left;
            }

            else if (key > root.data) {
                ans = root.data;
                root = root.right;
            }
        }

        return ans;
    }

}
