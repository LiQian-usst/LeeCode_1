package leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

    // 637.二叉树的层平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            // 层次遍历时一般通过size获取每一层的数量
            int cnt = queue.size();
            double sum = 0;
            for(int i=0;i<cnt;i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(sum/cnt);
        }
        return res;
    }
}
