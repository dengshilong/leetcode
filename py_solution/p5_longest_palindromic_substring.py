class Solution:
    def longestPalindrome(self, s):
        if len(s) < 2:
            return s
        length = 0
        result = ''
        for i in range(len(s)):
            if self.is_palindrome(s, i - length - 1, i):
                result = s[i - length - 1: i + 1]
                length += 2
            elif self.is_palindrome(s, i - length, i):
                result = s[i - length: i + 1]
                length += 1
        return result

    def is_palindrome(self, s, start, end):
        if start < 0 or end >= len(s):
            return False
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True


if __name__ == "__main__":
    solution = Solution()
    assert solution.longestPalindrome('babad') == 'bab'
    assert solution.longestPalindrome('cbbd') == 'bb'