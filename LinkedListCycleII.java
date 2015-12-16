
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if (head == null) 
        	return null;
        ListNode cur = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
        	if (cur == fast) {
        		int loopSize = 1;
        		fast = fast.next;
        		while (cur != fast) {
        			fast = fast.next;
        			loopSize++;
        		}
        		fast = head;
        		cur = head;
        		for (int i = loopSize; i > 0; i--) {
        			fast = fast.next;
        		}
        		while (fast != cur) {
        			cur = cur.next;
        			fast = fast.next;
        		}
        		return cur;
        	}
        	fast = fast.next.next;
        	cur = cur.next;
        }
        return null;
    }
}
