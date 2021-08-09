package leecode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {
    // 513.找最左下角的值
    public int findBottomLeftValue(TreeNode root) {
        int res=0;
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
           int cnt = queue.size();
           for(int i=0;i<cnt;i++){
               TreeNode node = queue.poll();
               if(i==0){
                   res = node.val;
               }
               if(node.left!=null){
                   queue.add(node.left);
               }
               if(node.right!=null){
                   queue.add(node.right);
               }
           }
        }
        return res;
    }
}
