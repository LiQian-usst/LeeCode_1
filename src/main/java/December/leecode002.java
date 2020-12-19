package December;
public class leecode002 {

    //定义单链表
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val){
             this.val = val;
         }
         ListNode(int val, ListNode next) {
             this.val = val;
             this.next = next;
         }
     }

    /*
    *
    * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
    * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    *
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //用于标记当前位的加法是否需要进位
        int flag = 0;
        ListNode current = new ListNode();
        ListNode head = current;
        boolean isl1End = false;
        boolean isl2End = false;
        while(l1!=null || l2!=null){
            if(l1.val+l2.val+flag<10){
                current.next=new ListNode(l1.val+l2.val+flag);
                flag=0;
            }else {
                current.next=new ListNode((l1.val+l2.val+flag)%10);
                flag=1;
            }
            if(l1.next!=null){
                l1 = l1.next;
            }else {
                l1.val = 0;
                isl1End = true;
            }
            if(l2.next!=null){
                l2 = l2.next;
            }else {
                l2.val = 0;
                isl2End = true;
            }
            current = current.next;
            if(isl1End && isl2End){
                //避免最后一位进位丢失
                if(flag == 0){
                    return head.next;
                }else {
                    current.next=new ListNode(1);
                }
                return head.next;
            }
        }
        return head.next;
    }
}
