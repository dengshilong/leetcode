/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月15日 下午5:30:01 
* 
*/
public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode fast = head;
         ListNode slow = head;
         while (fast != null) {
             if (n-- < 0) {
                 slow = slow.next;
             }
             fast = fast.next;
         }
         if (n < 0) {
             slow.next = slow.next.next;
         } else {
             head = head.next;
         }
         return head;
    }
}
