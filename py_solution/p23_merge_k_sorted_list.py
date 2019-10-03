from py_solution.common import create_node_list, node_list_to_list


class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if lists is None or len(lists) == 0:
            return None
        return self._mergeKLists(lists, 0, len(lists) - 1)
    def _mergeKLists(self, lists, left, right):
        if left == right:
            return lists[left]
        elif left < right:
            mid = (right - left) // 2 + left
            left = self._mergeKLists(lists, left, mid)
            right = self._mergeKLists(lists, mid + 1, right)
            return self.mergeTwoLists(left, right)

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
    solution = Solution()
    lists = [create_node_list([1, 4, 5]), create_node_list([1, 3, 4]), create_node_list([2, 6])]
    res = solution.mergeKLists(lists)
    assert node_list_to_list(res) == [1, 1, 2, 3, 4, 4, 5, 6]

