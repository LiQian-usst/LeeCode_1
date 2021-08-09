package leecode.tree;

public class IsBalanced {
    // 110.平衡二叉树
    public boolean isBalanced(TreeNode root) {
       if(root==null){
           return true;
       }
       return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 计算树的高度
    public int height(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
}
