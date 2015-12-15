/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月14日 下午11:11:18 
* 
*/
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
	private ListNode mergeKLists(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		} else if (start < end){
			int mid = (end - start) / 2 + start;
			ListNode left = mergeKLists(lists, start, mid);
			ListNode right = mergeKLists(lists, mid + 1, end);
			return mergeTwoLists(left, right);
		} else {
			return null;
		}
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		if (l1.val <= l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode cur = head;
	    while (l1 != null && l2 != null) {
	    	if (l1.val <= l2.val){
	    		cur.next = l1;
	    		l1 = l1.next;
	    	} else {
	    		cur.next = l2;
	    		l2 = l2.next;
	    	}
	    	cur = cur.next;
	    }
	    if (l1 != null) {
	    	cur.next = l1;
	    } else {
	    	cur.next = l2;
	    }
	    return head;
    }
}
