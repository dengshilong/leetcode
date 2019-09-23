class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        a = 1
        b = 1
        while n > 0:
            temp = a + b
            a = b
            b = temp
            n -= 1
        return a


if __name__ == "__main__":
    solution = Solution()
    assert solution.climbStairs(2) == 2
    assert solution.climbStairs(3) == 3
