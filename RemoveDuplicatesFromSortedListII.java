
public class RemoveDuplicatesFromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode d = dummy;
		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
			} else {
				d.next = head;
				d = d.next;
			}
			head = head.next;	
		}
		d.next = null;
		return dummy.next;
    }
}
