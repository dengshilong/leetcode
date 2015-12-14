
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int remain = 0;
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
        	int temp = l1.val + l2.val + remain;
        	ListNode node = new ListNode(temp % 10);
        	cur.next = node;
        	cur = cur.next;
        	remain = temp / 10;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        ListNode node = (l1 == null ? l2 : l1);
        while (node != null) {
        	int temp = node.val  + remain;
        	ListNode listNode = new ListNode(temp % 10);
         	remain = temp / 10;
        	cur.next = listNode;
        	cur = cur.next;
        	node = node.next;
        }
        if (remain != 0) {
        	ListNode listNode = new ListNode(remain);
        	cur.next = listNode;
        }
        return dummy.next;
    }
}
