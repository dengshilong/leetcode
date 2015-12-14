
public class IntersectionOfTwoLinkedLists {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
	    int la = listLength(headA);
	    int lb = listLength(headB);
	    ListNode ca = headA;
	    ListNode cb = headB;
	    if (la > lb) {
	        int temp = la - lb;
	        while (temp > 0) {
	            ca = ca.next;
	            temp--;
	        }
	    } else {
	        int temp = lb - la;
	        while (temp > 0) {
	            cb = cb.next;
	            temp--;
	        }
	    }
	    while (ca != null && cb != null) {
	        if (ca == cb) {
	            return ca;
	        } else {
	            ca = ca.next;
	            cb = cb.next;
	        }
	    }
	    return null;
	}
	public static int listLength(ListNode head) {
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
}
