package leecode.fenzhi;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    // 95. 不同的二叉搜索树 II
    public List<TreeNode> generateTrees(int n) {
       return backTrace(1,n);
    }

    public List<TreeNode> backTrace(int start, int end){
        List<TreeNode> allTrees = new ArrayList<>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i=start;i<=end;i++){
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = backTrace(start, i - 1);
            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = backTrace(i + 1, end);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
