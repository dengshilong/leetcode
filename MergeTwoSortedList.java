


public class MergeTwoSortedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode n1 = l1;
		ListNode n2 = l2;
		if (n1.val <= n2.val) {
			head = n1;
			n1 = n1.next;
		} else {
			head = n2;
			n2 = n2.next;
		}
		ListNode cur = head;
	    while (n1 != null && n2 != null) {
	    	if (n1.val <= n2.val){
	    		cur.next = n1;
	    		n1 = n1.next;
	    	} else {
	    		cur.next = n2;
	    		n2 = n2.next;
	    	}
	    	cur = cur.next;
	    }
	    while (n1 != null) {
	    	cur.next = n1;
	    	n1 = n1.next;
	    	cur = cur.next;
	    }
	    while (n2 != null) {
	    	cur.next = n2;
	    	n2 = n2.next;
	    	cur = cur.next;
	    }
	    return head;
    }
}
