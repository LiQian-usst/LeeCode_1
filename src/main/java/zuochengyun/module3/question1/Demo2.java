package zuochengyun.module3.question1;

import zuochengyun.module3.TreeNode;
import java.util.Stack;

/**
 * @author qian.li
 * @title: Demo2
 * @description:
 * @date 2021/3/10 18:32
 */
public class Demo2 {

    // 非递归先序
    public void preOrderUnRecur(TreeNode treeNode){
        if(treeNode!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(treeNode);
            while(!stack.empty()){
                TreeNode node = stack.pop();
                System.out.println(node.value);
                if(node.left!=null){
                    stack.push(node.left);
                }
                if(node.right!=null){
                    stack.push(node.right);
                }
            }
        }
    }

    //  非递归中序
    public void middleOrderUnRecur(TreeNode treeNode){
        if(treeNode!=null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.empty() || treeNode!=null){
                if(treeNode!=null){
                    stack.push(treeNode);
                    treeNode = treeNode.left;
                }else {
                    treeNode = stack.pop();
                    System.out.println(treeNode.value);
                    treeNode = treeNode.right;
                }
            }
        }
    }
}
