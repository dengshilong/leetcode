from py_solution.common import create_node_list, print_node_list


class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = None
        if l1 == None or l2 == None:
            head = l1 if l1 else l2
            return head
        if l1.val < l2.val:
            head = l1
            l1 = l1.next
        else:
            head = l2
            l2 = l2.next
        cur = head
        while l1 != None and l2 != None:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
                cur = cur.next
            else:
                cur.next = l2
                l2 = l2.next
                cur = cur.next
        node = l1 if l1 != None else l2
        while node != None:
            cur.next = node
            node = node.next
            cur = cur.next
        return head


if __name__ == "__main__":
    l1 = create_node_list([1, 2, 4])
    l2 = create_node_list([1, 3, 4])
    solution = Solution()
    res = solution.mergeTwoLists(l1, l2)
    assert print_node_list(res) == [1, 1, 2, 3, 4, 4]
    res = solution.mergeTwoLists(create_node_list([1, 2, 3]), create_node_list([]))
    assert print_node_list(res) == [1, 2, 3]

