package leecode.tree;

public class IsSubtree {
    // 572.另一棵树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    // 从一个结点开始检测两个树是否匹配
    public boolean check(TreeNode s, TreeNode t) {
        // 终止条件1
        if(s==null && t==null){
            return true;
        }
        // 终止条件2
        if(s==null || t==null || s.val!=t.val){
            return false;
        }
        return check(s.left,t.left)&&check(s.right,t.right);
    }
}
