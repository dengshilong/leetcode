class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.lower()
        i = 0
        j = len(s) - 1
        while i < j:
            while i < j and not s[i].isalnum():
                i += 1
            while i < j and not s[j].isalnum():
                j -= 1
            if i > j or s[i] != s[j]:
                return False
            else:
                i += 1
                j -= 1
        return True


if __name__ == "__main__":
    solution = Solution()
    assert solution.isPalindrome('A man, a plan, a canal: Panama') == True
    assert solution.isPalindrome('race a car') == False
    assert solution.isPalindrome('op') == False
    assert solution.isPalindrome('0P') == False
