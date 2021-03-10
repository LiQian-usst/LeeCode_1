package zuochengyun.module3.question1;

import zuochengyun.module3.TreeNode;

/**
 * @author qian.li
 * @title: Demo1
 * @description:
 * @date 2021/3/10 18:20
 */
public class Demo1 {
    // 递归先序
    public void preOrderRecur(TreeNode treeNode){
        if(treeNode != null){
            System.out.println(treeNode.value);
            preOrderRecur(treeNode.left);
            preOrderRecur(treeNode.right);
        }
    }

    // 递归中序
    public void middleOrderRecur(TreeNode treeNode){
        if(treeNode != null){
            preOrderRecur(treeNode.left);
            System.out.println(treeNode.value);
            preOrderRecur(treeNode.right);
        }
    }


    // 递归后序
    public void posOrderRecur(TreeNode treeNode){
        if(treeNode != null){
            preOrderRecur(treeNode.left);
            System.out.println(treeNode.value);
            preOrderRecur(treeNode.right);
        }
    }
}
