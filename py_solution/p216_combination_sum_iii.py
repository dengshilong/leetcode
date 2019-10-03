class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        nums = []
        s = [i for i in range(1, 10)]
        self._combination_sum(s, 0, n, k, nums, res)
        return res

    def _combination_sum(self, candidates, start, remain, k, nums, res):
        if remain == 0 and k == len(nums):
            res.append([i for i in nums])
            return
        if len(nums) == k or remain < 0 or start == len(candidates):
            return
        for i in range(start, len(candidates)):
            nums.append(candidates[i])
            self._combination_sum(candidates, i + 1, remain - candidates[i], k, nums, res)
            nums.pop()


if __name__ == "__main__":
    solution = Solution()
    assert solution.combinationSum3(3, 7) == [[1,2,4]]
    assert solution.combinationSum3(3, 9) == [[1,2,6], [1,3,5], [2,3,4]]
