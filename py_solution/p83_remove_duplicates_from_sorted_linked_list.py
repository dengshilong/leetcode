from py_solution.common import create_node_list, node_list_to_list


class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        pre = head
        cur = head.next
        while cur != None:
            if pre.val == cur.val:
                pre.next = cur.next
                cur = pre.next
            else:
                pre = cur
                cur = cur.next
        return head


if __name__ == "__main__":
    solution = Solution()
    head = create_node_list([1, 1])
    head = solution.deleteDuplicates(head)
    assert node_list_to_list(head) == [1]
    head = create_node_list([1, 1, 2])
    head = solution.deleteDuplicates(head)
    assert node_list_to_list(head) == [1, 2]
    head = create_node_list([1, 1, 2, 3, 3])
    head = solution.deleteDuplicates(head)
    assert node_list_to_list(head) == [1, 2, 3]
