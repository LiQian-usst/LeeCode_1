package leecode.tree;

public class IsBalanced2 {
    public boolean isBalanced2(TreeNode root) {
        return height(root)>=0;
    }

    public int height(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int leftHeight =  height(treeNode.left);
        int rightHeight =  height(treeNode.right);
        // 相比MaxDepth方法只多了这一句
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
