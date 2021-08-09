package leecode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    List<Integer> res = new ArrayList<>();
    // 1.递归的方式实现二叉树的先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        res.add(root.val);
        if(root.left!=null){
            preorderTraversal(root.left);
        }
        if(root.right!=null){
            preorderTraversal(root.right);
        }
    }


    // 2.非递归的方式实现二叉树的先序遍历
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res2 = new ArrayList<>();
        if(root==null){
            return res2;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res2.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res2;
    }
}
