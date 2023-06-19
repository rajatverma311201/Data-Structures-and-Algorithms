package tree.binary_tree.traversal;

public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> traverse(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = false;
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

            if (flag) {
                Collections.reverse(li);
            }
            ans.add(new ArrayList<>(li));
            flag = !flag;
        }
        return ans;
    }

}
