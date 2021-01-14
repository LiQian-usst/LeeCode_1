package January;

/**
 * @author qian.li
 * @title: leecode019
 * @description:
 * @date 2021/1/14 19:12
 */
public class leecode019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int count = 0;
        while(node!=null){
            count++;
            node = node.next;
        }
        node = head;
        int index = 1;
        while(node!=null && index!=count-n){
            index++;
            node = node.next;
        }
        if(node == null){
            return head.next;
        }
        node.next = node.next.next;
        return head;
    }
}
