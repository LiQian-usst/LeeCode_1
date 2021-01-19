package January;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author qian.li
 * @title: leecode098
 * @description:
 * @date 2021/1/19 18:41
 */
public class leecode098 {
    // 方法一
    public boolean isValidBST1(TreeNode root) {
        //用栈帮助实现二叉树的中序非递归遍历
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode treeNode = stack.pop();
            if(treeNode.val<=inorder){
                return false;
            }
            inorder = treeNode.val;
            root = treeNode.right;
        }
        return true;
    }

    // 方法二
    public boolean isValidBST2(TreeNode root) {
        //用栈帮助实现二叉树的中序非递归遍历
        return helper(root,null,null);
    }

    public boolean helper(TreeNode treeNode, Integer low, Integer up){
        if(treeNode==null){
            return true;
        }
        int val = treeNode.val;
        if(low!=null&&val<=low){
            return false;
        }
        if(up!=null&&val>=up){
            return false;
        }
        if(!helper(treeNode.left,low,val)){
            return false;
        }
        if(!helper(treeNode.right,val,up)){
            return false;
        }
        return true;
    }

}
