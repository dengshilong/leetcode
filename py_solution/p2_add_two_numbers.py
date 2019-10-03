from py_solution.common import ListNode


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(0)
        remain = 0
        cur = dummy
        while l1 != None and l2 != None:
            temp = l1.val + l2.val + remain
            node = ListNode(temp % 10)
            cur.next = node
            cur = cur.next
            remain = temp / 10
            l1 = l1.next
            l2 = l2.next
        node = l2 if l1 is None else l1
        while node != None:
            temp = node.val + remain
            temp_node = ListNode(temp % 10)
            remain = temp / 10
            cur.next = temp_node
            cur = cur.next
            node = node.next
        if remain != 0:
            node = ListNode(remain)
            cur.next = node
        return dummy.next


if __name__ == "__main__":
    pass

