package leecode.Search.BackTrace;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    // 257.二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        backTrace(root,result,curPath);
        return  result;
    }

    private void backTrace(TreeNode node,List<String> result,List<Integer> curPath){
        if(node == null){
            return;
        }
        curPath.add(node.val);
        if(isLeaf(node)){
            result.add(buildPath(curPath));
        }else {
            backTrace(node.left,result,curPath);
            backTrace(node.right,result,curPath);
        }
        curPath.remove(curPath.size()-1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }
}
