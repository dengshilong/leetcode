

public class SwapNodeInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode pre = null;
        ListNode newHead = null;
        while (true) {
        	if (newHead == null) {
        		newHead = fast;
        	}
        	slow.next = fast.next;
        	if (pre != null) {
        		pre.next = fast;
        	} 
        	fast.next = slow;
        	pre = slow;
        	ListNode temp = fast;
        	fast = slow;
        	slow = temp;
        	if (fast.next == null || fast.next.next == null) {
        		break;
        	}
        	fast = fast.next.next;
        	slow = slow.next;	
        }
        return newHead;
    }
}
