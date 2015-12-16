

public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        while (cur != null) {
        	ListNode p = dummy;
        	while (p.next != null && p.next.val <= cur.val) {
        		p = p.next;
        	}
        	ListNode temp = p.next;
        	p.next = cur;
        	ListNode next = cur.next;
        	cur.next = temp;
        	cur = next;
        }
        return dummy.next;
    }
}
