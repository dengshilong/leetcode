
public class ReverseNodesInKGroup {
     public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1)
            return head;
        return reverseKGroupHelper(head, k);
    }
    private static ListNode reverseKGroupHelper(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode cur = head;
        int n = k;
        while (cur != null && n > 1) {
            cur = cur.next;
            n--;
        }
        if (n > 1) {
            return head;
        } else {
            if (cur == null) {
                return head;
            } else if (cur.next == null) {
                return reverseList(head);
            } else {
                ListNode right = reverseKGroupHelper(cur.next, k);
                cur.next = null;
                ListNode newHead = reverseList(head);
                head.next = right;
                return newHead;
            }
        }
    }
}
