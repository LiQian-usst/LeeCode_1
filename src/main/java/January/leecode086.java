package January;

public class leecode086 {
    // 分隔链表
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        largeHead = largeHead.next;
        small.next = largeHead;
        return smallHead.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
