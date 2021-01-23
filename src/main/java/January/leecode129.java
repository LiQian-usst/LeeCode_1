package January;

import DataStructure.TreeNode;
import com.sun.javafx.binding.StringFormatter;
import org.junit.Test;

import java.util.Stack;

public class leecode129 {
    // 求根到叶子结点数字之和 (注意根节点的判断方式，避免重复相加)
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public Integer dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
    
}
