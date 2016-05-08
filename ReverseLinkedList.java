

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode next = cur.next;
        cur.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        return cur;
    }
}
