class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        nums = []
        s = [i for i in candidates]
        s.sort()
        self._combination_sum(s, 0, target, nums, res)
        return res

    def _combination_sum(self, candidates, start, remain, nums, res):
        if remain < 0 or start == len(candidates):
            return
        if remain == 0:
            res.append([i for i in nums])
            return
        for i in range(start, len(candidates)):
            if candidates[i] > remain:
                break
            nums.append(candidates[i])
            self._combination_sum(candidates, i, remain - candidates[i], nums, res)
            nums.pop()


if __name__ == "__main__":
    solution = Solution()
    assert solution.combinationSum([2,3,6,7], 7) == [[2, 2, 3], [7]]
    assert solution.combinationSum([2,3,5], 8) == [[2,2,2,2], [2,3,3], [3,5]]
    assert solution.combinationSum([8,7,4,3], 11) == [[3,4,4],[3,8],[4,7]]