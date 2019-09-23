class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        # length = 0
        # last = 0
        # flag = True
        # for c in s:
        #     if c == ' ':
        #         if not flag:
        #             last = length
        #             length = 0
        #             flag = True
        #     else:
        #         length += 1
        #         flag = False
        # return last if flag else length
        return len(s.strip().split(' ')[-1])


if __name__ == "__main__":
    solution = Solution()
    assert solution.lengthOfLastWord("Hello World") == 5
    assert solution.lengthOfLastWord("a") == 1
    assert solution.lengthOfLastWord("a ") == 1
    assert solution.lengthOfLastWord("b a  ") == 1
