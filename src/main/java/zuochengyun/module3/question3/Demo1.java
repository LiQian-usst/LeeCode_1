package zuochengyun.module3.question3;

import zuochengyun.module3.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Demo1 {
    // 二叉树的序列化(先序)
    public String serialTree(TreeNode treeNode){
        StringBuilder sb = new StringBuilder();
        if(treeNode==null){
            return sb.toString();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while(stack!=null){
            TreeNode node = stack.pop();
            sb.append(node.value+'!');
            if(node.left!=null){
                stack.push(node.left);
            }else {
                sb.append("#!");
            }
            if(node.right!=null){
                stack.push(node.right);
            }else {
                sb.append("#!");
            }
        }
        return sb.toString();
    }

    // 二叉树的反序列化
    public TreeNode deSerialTree(String str){
        String[] split = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<split.length;i++){
            queue.offer(split[i]);
        }
        return reconPreOrder(queue);
    }

    public TreeNode reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        // 结束点
        if(value.equals("#")){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(value));
        treeNode.left = reconPreOrder(queue);
        treeNode.right = reconPreOrder(queue);
        return treeNode;
    }
}
