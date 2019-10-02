class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        res = []
        level = [root]
        while level:
            res.append([i.val for i in level])
            temp = []
            for r in level:
                if r.left:
                    temp.append(r.left)
                if r.right:
                    temp.append(r.right)
            level = temp
        return res

if __name__ == "__main__":
    pass