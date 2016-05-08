/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 下午2:06:56 
* 
*/
public class SortList {
    public static ListNode sortList(ListNode head) {
        return mergeSortList(head);
    }
    public static ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = mergeSortList(slow.next);
        slow.next = null;
        ListNode left = mergeSortList(head);
        head = mergeTwoLists(left, right);
        return head;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
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
        cur.next = (n1 != null) ? n1 : n2;
        return head;
    }
}
