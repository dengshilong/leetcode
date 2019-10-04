class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        cur = []
        nums = [i for i in range(1, n + 1)]
        res = []
        self._combine(0, nums, cur, k, res)
        return res

    def _combine(self, start, nums, cur, k, res):
        if len(cur) == k:
            res.append([i for i in cur])
            return
        if start >= len(nums):
            return
        i = start
        while i < len(nums):
            cur.append(nums[i])
            self._combine(i + 1, nums, cur, k, res)
            cur.pop()
            i += 1

if __name__ == "__main__":
    solution = Solution()
    assert solution.combine(4, 2) == [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]