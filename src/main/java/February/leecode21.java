package February;

import DataStructure.ListNode;

/**
 * @author qian.li
 * @title: leecode21
 * @description:
 * @date 2021/2/23 19:44
 */
public class leecode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head = null;
        if(l1.val<l2.val){
            head = l1;
            l1=l1.next;
        }else {
            head = l2;
            l2=l2.next;
        }
        ListNode index = head;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                index.next=l1;
                l1=l1.next;
            }else {
                index.next=l2;
                l2=l2.next;
            }
            index = index.next;
        }
        if(l1==null){
            index.next=l2;
        }
        if(l2==null){
            index.next=l1;
        }
        return head;
    }
}
