package leecode.linkedlist;

public class IsPalindrome {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode frontPointer;
    private boolean recursivelyCheck(ListNode currentNode){
        if(currentNode!=null){
            // 1.子结点不满足
            if(!recursivelyCheck(currentNode.next)){
                return false;
            }
            //2.当前结点不满足
            if(currentNode.val!=frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(frontPointer);
    }
}
