/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午10:40:00 
* 
*/
public class ReverseLinkedListII {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode next = cur.next;
        cur.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        return cur;
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = head;
        ListNode second = head;
        while (n > 1) {
            first = first.next;
            n--;
        }
        ListNode pre = null;
        while (m > 1) {
            pre = second;
            second = second.next;
            m--;
        }
        ListNode other = first.next;
        first.next = null;
        ListNode temp = reverseList(second);
        second.next = other;
        if (pre != null) {
            pre.next = temp;
            return head;
        } else {
            return temp;
        }
    }
}
