package January;

import DataStructure.TreeNode;
/**
 * @author qian.li
 * @title: leecode101
 * @description:
 * @date 2021/1/21 18:49
 */
public class leecode101 {
    // 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public boolean check(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return p.val==q.val && check(p.left,q.right) && check(p.right,q.left);
    }
}
