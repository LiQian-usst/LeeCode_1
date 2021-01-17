package January;

public class leecode110 {
    // 判断平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }else if(Math.abs(getDepth(root.left)-getDepth(root.right))>1){
            return false;
        }else {
            return isBalanced(root.left)&&isBalanced(root.right);
        }
    }

    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }else {
            return Math.max(getDepth(root.left),getDepth(root.right))+1;
        }
    }
}
