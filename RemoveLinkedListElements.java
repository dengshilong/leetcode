
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) 
            return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
            } else {
                if (pre == null) {
                    head = cur.next;
                } else {
                    pre.next = cur.next;
                }
            }
            cur = cur.next;
        }
        return head;    
    }
}
