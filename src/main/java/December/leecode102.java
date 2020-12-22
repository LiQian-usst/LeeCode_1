package December;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leecode102 {
    /*
    * 二叉树的层次遍历
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root ==null){
            return result;
        }
        //使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            //标记当前层的结点个数
            int currentLevelSize = queue.size();
            for(int i=0;i<currentLevelSize;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
