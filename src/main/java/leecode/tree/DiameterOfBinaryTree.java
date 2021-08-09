package leecode.tree;

public class DiameterOfBinaryTree {
    int maxSize = 0;
    // 543.二叉树的直径
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxSize;
    }

    public int height(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight+rightHeight>maxSize){
            maxSize = leftHeight+rightHeight;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
