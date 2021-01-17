package January;

import java.util.ArrayList;
import java.util.List;

public class leecode094 {
    // 二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        return middleTrace(list,root);
    }

    public List<Integer> middleTrace(List<Integer> list,TreeNode root){
        if(root.left!=null){
            middleTrace(list,root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            middleTrace(list,root.right);
        }
        return list;
    }
}
