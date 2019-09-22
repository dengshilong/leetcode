#Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


def create_node_list(nums):
    if not nums:
        return None
    head = ListNode(nums[0])
    cur = head
    for i in range(1, len(nums)):
        node = ListNode(nums[i])
        cur.next = node
        cur = cur.next
    return head


def print_node_list(head):
    result = []
    cur = head
    while cur != None:
        result.append(cur.val)
        cur = cur.next
    return result

