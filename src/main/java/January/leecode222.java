package January;

import DataStructure.TreeNode;

public class leecode222 {
    // 完全二叉树的结点个数
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
