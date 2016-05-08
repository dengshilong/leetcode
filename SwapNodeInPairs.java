

public class SwapNodeInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        head = head.next;
        ListNode pre = null;
        while (cur != null && cur.next != null) {
            ListNode a = cur.next;
            ListNode b = cur.next.next;
            if (pre != null) {
                pre.next = a;
            }
            a.next = cur;
            cur.next = b;
            pre = cur;
            cur = b;
        }
        return head;
    }
}
