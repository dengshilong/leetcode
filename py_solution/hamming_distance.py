class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        n = x ^ y
        count = 0
        while n > 0:
            n = n & n - 1
            count += 1
        return count


if __name__ == "__main__":
    solution = Solution()
    assert solution.hammingDistance(1, 4) == 2