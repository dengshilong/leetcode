class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        for x in nums:
            res ^= x
        return res


if __name__ == "__main__":
    solution = Solution()
    assert solution.singleNumber([2,2,1]) == 1