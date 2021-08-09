package leecode.linkedlist;

import org.junit.Test;

public class demo1 {

    // 递归的方式从后向前打印链表
    private void recursivelyCheck(IsPalindrome.ListNode currentNode){
        if(currentNode.next!=null){
            recursivelyCheck(currentNode.next);
        }
        System.out.println(currentNode.val);
    }

    @Test
    public void test(){
        IsPalindrome.ListNode listNode1 = new IsPalindrome.ListNode(1);
        IsPalindrome.ListNode listNode2 = new IsPalindrome.ListNode(2);
        IsPalindrome.ListNode listNode3 = new IsPalindrome.ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        recursivelyCheck(listNode1);
    }

}
