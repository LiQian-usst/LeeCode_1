package January;

import DataStructure.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class leecode113 {
    // 路径总和
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentVal = new ArrayList<>();
        if(root==null){
            return res;
        }
        backTrace(root,targetSum,res,currentVal);
        return res;
    }

    public void backTrace(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> currentVal){
        if(root.val==targetSum&&root.left==null&&root.right==null){
            currentVal.add(root.val);
            res.add(new ArrayList<>(currentVal));
        }else {
            currentVal.add(root.val);
            if(root.left!=null){
                backTrace(root.left,targetSum-root.val,res,currentVal);
            }
            if(root.right!=null){
                backTrace(root.right,targetSum-root.val,res,currentVal);
            }
        }
        currentVal.remove(currentVal.size()-1);
    }
}
