/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午10:30:34 
* 
*/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode next = partition(head.next, x);
        cur.next = next;
        if (cur.val >= x) {
            if (next != null && next.val < x) {
                head = next;
                while (next.next != null && next.next.val < x) {
                    next = next.next;
                }
                cur.next = next.next;
                next.next = cur;
            }
        }
        return head;
    }
}
