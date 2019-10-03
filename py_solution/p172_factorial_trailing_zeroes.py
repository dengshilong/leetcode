class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = 0
        while n >= 5:
            temp = n // 5
            res += temp
            n = temp
        return res



if __name__ == "__main__":
    solution = Solution()
    assert solution.trailingZeroes(3) == 0
    assert solution.trailingZeroes(5) == 1
    assert solution.trailingZeroes(10) == 2
    assert solution.trailingZeroes(25) == 6
