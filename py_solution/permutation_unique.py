class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        s = [i for i in nums]
        s.sort()
        self._recursion_permutation(s, 0, result)
        return result

    def reverse(self, nums, begin, end):
        while begin < end:
            nums[begin], nums[end] = nums[end], nums[begin]
            begin += 1
            end -= 1

    def _recursion_permutation(self, nums, start, result):
        if start == len(nums) - 1:
            result.append([i for i in nums])
            return
        i = len(nums)
        while i > start:
            self._recursion_permutation(nums, start + 1, result)
            while i > start and nums[i - 1] == nums[start]:
                i -= 1
            if i <= start:
                break
            nums[start], nums[i - 1] = nums[i - 1], nums[start]
            i -= 1
            if i <= start:
                break
            self.reverse(nums, start + 1, len(nums) - 1)


if __name__ == "__main__":
    solution = Solution()
    assert solution.permuteUnique([1, 1, 2]) == [[1,1,2],[1,2,1],[2,1,1]]
    assert solution.permuteUnique([3, 3, 0, 3]) == [[0,3,3,3],[3,0,3,3],[3,3,0,3],[3,3,3,0]]
