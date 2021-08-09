package leecode.tree;

public class MinDepth {
    // 111.二叉树的最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }
}
