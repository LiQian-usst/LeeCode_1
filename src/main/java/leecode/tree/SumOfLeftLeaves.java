package leecode.tree;

public class SumOfLeftLeaves {

    // 404.左叶子之和
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    // 递归有两种情况：1.结束；2.继续递归；
    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    // 判断一个节点是不是叶子节点
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
