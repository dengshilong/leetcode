

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode cur = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (cur == fast) {
				return true;
			} 
			fast = fast.next.next;
			cur = cur.next;
		}
		return false;	     
    }
}
