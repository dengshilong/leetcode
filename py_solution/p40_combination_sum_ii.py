class Solution(object):
    def combinationSum2(self, candidates, target):
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
        if remain == 0:
            res.append([i for i in nums])
            return
        if remain < 0 or start == len(candidates):
            return
        for i in range(start, len(candidates)):
            if candidates[i] > remain:
                break
            if i == start or candidates[i] != candidates[i - 1]:
                nums.append(candidates[i])
                self._combination_sum(candidates, i + 1, remain - candidates[i], nums, res)
                nums.pop()


if __name__ == "__main__":
    solution = Solution()
    print(solution.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
    assert solution.combinationSum2([2, 5, 2, 1, 2], 5) == [[1, 2, 2], [5]]
