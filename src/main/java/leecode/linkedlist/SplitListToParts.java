package leecode.linkedlist;

public class SplitListToParts {

    public class ListNode {
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

    public ListNode[] splitListToParts(ListNode head, int k) {
        // 0.声明数组
        ListNode[] result = new ListNode[k];
        // 1.计算链表的长度
        ListNode cur = head;
        int total = 0;
        while(cur!=null){
            total++;
            cur = cur.next;
        }
        // 2.每个数组中链表的基本长度
        int size = total/k;
        // 3.前mod个数组中每个长度加1
        int mod = total%k;
        cur = head;
        for(int i=0;i<k&&cur!=null;i++){
            int curSize = i<mod?size+1:size;
            result[i] = cur;
            int j = 0;
            while(j<curSize-1){
                cur=cur.next;
                j++;
            }
            // 断开的操作
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return result;
    }
}
