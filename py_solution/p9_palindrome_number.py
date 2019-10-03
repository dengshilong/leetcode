class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if 0 <= x and x <= 9:
            return True
        if x < 0 or x % 10 == 0:
            return False
        y = 0
        while x > y:
            y = y * 10 + x % 10
            x = int(x / 10)
        return x == y or int(y / 10) == x


if __name__ == "__main__":
    solution = Solution()
    assert solution.isPalindrome(2345432) == True
    assert solution.isPalindrome(-23) == False

