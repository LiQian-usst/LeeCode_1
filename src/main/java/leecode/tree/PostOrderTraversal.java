package leecode.tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    // 二叉树后续非递归遍历
    // 前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。
    // 可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ret.add(cur.val);
            if(cur.left!=null){
                stack.push(cur.left);
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
        }
        Collections.reverse(ret);
        return ret;
    }
}
