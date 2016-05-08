


public class RotateList {
    int listLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = listLength(head);
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
