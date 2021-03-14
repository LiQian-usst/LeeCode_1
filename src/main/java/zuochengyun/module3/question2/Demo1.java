package zuochengyun.module3.question2;

import zuochengyun.module3.TreeNode;

// 二叉树的最小深度
// 最小深度：最小深度是从根节点到最近叶子节点的最短路径上的节点数量
// 最大深度：最大深度是从根节点到最近叶子节点的最长路径上的节点数量
public class Demo1 {
    public int minDepth(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        return getMinDepth(treeNode,1);
    }

    public int getMinDepth(TreeNode treeNode,int level){
        if(treeNode.left==null && treeNode.right==null){
            return level;
        }
        int min = Integer.MIN_VALUE;
        if(treeNode.left!=null){
            min = Math.min(getMinDepth(treeNode.left,level+1),min);
        }
        if(treeNode.right!=null){
            min = Math.min(getMinDepth(treeNode.right,level+1),min);
        }
        return min;
    }
}
