from functools import cmp_to_key


class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        if not intervals:
            return []
        s = sorted(intervals, key=cmp_to_key(self._compare))
        res = []
        cur = s[0]
        for i in range(1, len(s)):
            if s[i][0] >= cur[0] and s[i][0] <= cur[1]:
                if s[i][1] >= cur[1]:
                    cur = [cur[0], s[i][1]]
            else:
                res.append(cur)
                cur = s[i]
        res.append(cur)
        return res

    def _compare(self, a, b):
        if a[0] < b[0]:
            return a[0] - b[0]
        elif a[0] > b[0]:
            return a[0] - b[0]
        return a[1] - b[1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.merge([[1,4],[0,4]]) == [[0, 4]]
    assert solution.merge([[1,3],[2,6],[8,10],[15,18]]) == [[1,6],[8,10],[15,18]]
    assert solution.merge([[1,4],[4,5]]) == [[1,5]]
    assert solution.merge([[1,4],[2,3]]) == [[1, 4]]