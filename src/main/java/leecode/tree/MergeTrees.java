package leecode.tree;

public class MergeTrees {
    // 617.合并二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 从根节点开始合并，有三种情况
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode node = new TreeNode(root1.val+root2.val);
        node.left = mergeTrees(root1.left,root2.left);
        node.right = mergeTrees(root1.right,root2.right);
        return node;
    }
}
