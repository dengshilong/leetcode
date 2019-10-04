class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return self._subsets(0, len(nums) - 1, nums)

    def _subsets(self, left, right, nums):
        if left > right:
            return [[]]
        s = []
        temp = self._subsets(left, right - 1, nums)
        s.extend(temp)
        for item in temp:
            t = [i for i in item]
            t.append(nums[right])
            s.append(t)
        return s


if __name__ == "__main__":
    solution = Solution()
    print(solution.subsets([1, 2, 3]))