class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n <= 0:
            return False
        return n & (n - 1) == 0


if __name__ == "__main__":
    solution = Solution()
    assert solution.isPowerOfTwo(1) == True
    assert solution.isPowerOfTwo(16) == True
    assert solution.isPowerOfTwo(218) == False